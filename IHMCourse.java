import javax.swing.*;
import java.awt.*;
import java.util.List;

public class IHMCourse extends JFrame {
    private Course course;
    private JTextArea displayArea; // Zone d'affichage

    public IHMCourse() {
        setTitle("Gestion de la Course de Voile");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        JButton creerCourseButton = new JButton("Créer une course");
        JButton ajouterBateauButton = new JButton("Ajouter un bateau");
        JButton saisirTempsButton = new JButton("Saisir les temps");
        JButton afficherResultatsButton = new JButton("Afficher les résultats");

        buttonPanel.add(creerCourseButton);
        buttonPanel.add(ajouterBateauButton);
        buttonPanel.add(saisirTempsButton);
        buttonPanel.add(afficherResultatsButton);

        // Zone de texte pour afficher les informations
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        // Ajout des listeners pour les boutons
        creerCourseButton.addActionListener(e -> creerCourse());
        ajouterBateauButton.addActionListener(e -> ajouterBateau());
        saisirTempsButton.addActionListener(e -> saisirTemps());
        afficherResultatsButton.addActionListener(e -> afficherResultats());
    }

    public void creerCourse() {
        String titre = JOptionPane.showInputDialog(this, "Entrez le titre de la course :");
        if (titre != null && !titre.isEmpty()) {
            course = new Course(titre);
            displayArea.append("Course créée : " + titre + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Aucun titre saisi, aucune course créée.");
        }
    }

public void ajouterBateau() {
    if (course == null) {
        JOptionPane.showMessageDialog(this, "Veuillez d'abord créer une course.");
        return;
    }

    // Demande le nom du bateau
    String nomBateau = JOptionPane.showInputDialog(this, "Entrez le nom du bateau :");
    if (nomBateau == null || nomBateau.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nom de bateau invalide.");
        return;
    }

    // Demande le type de bateau avec des boutons
    String[] options = {"MonoCoque", "MultiCoque"};
    int choixType = JOptionPane.showOptionDialog(
        this,
        "Type de bateau :",
        "Choix du Type",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]
    );

    if (choixType == -1) { // Fenêtre fermée ou aucun choix
        JOptionPane.showMessageDialog(this, "Type de bateau non sélectionné.");
        return;
    }

    String typeBateau = options[choixType];
    Bateau bateau;
    if ("MonoCoque".equalsIgnoreCase(typeBateau)) {
        bateau = new MonoCoque(nomBateau);
    } else {
        bateau = new MultiCoque(nomBateau);
    }

    // Demande le nom du capitaine
    String nomCapitaine = JOptionPane.showInputDialog(this, "Nom du capitaine :");
    if (nomCapitaine == null || nomCapitaine.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nom du capitaine invalide.");
        return;
    }
    String specialiteCapitaine = "Capitaine";

    Equipier capitaine = new Equipier(nomCapitaine, specialiteCapitaine);
    Equipage equipage = new Equipage(capitaine);

    // Demande le nombre d'équipiers
    int nbEquipiers;
    try {
        nbEquipiers = Integer.parseInt(JOptionPane.showInputDialog(this, "Nombre d'équipiers (max 6) :"));
        if (nbEquipiers < 0 || nbEquipiers > 6) {
            throw new NumberFormatException("Nombre hors limites");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Nombre d'équipiers invalide.");
        return;
    }

    // Ajoute les équipiers
    for (int i = 0; i < nbEquipiers; i++) {
        String nomEquipier = JOptionPane.showInputDialog(this, "Nom de l'équipier " + (i + 1) + " :");
        String specialiteEquipier = JOptionPane.showInputDialog(this, "Spécialité de l'équipier " + (i + 1) + " :");
        if (nomEquipier == null || nomEquipier.trim().isEmpty() || specialiteEquipier == null || specialiteEquipier.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Données de l'équipier invalide. Ajout annulé.");
            return;
        }
        equipage.ajoutEquipier(new Equipier(nomEquipier, specialiteEquipier));
    }

    // Affecte l'équipage au bateau et inscrit le bateau à la course
    bateau.affecterEquipage(equipage);
    course.inscrireBateau(bateau, equipage);

    // Affiche les informations ajoutées
    displayArea.append("Bateau ajouté : " + nomBateau + " (" + typeBateau + ")\n");
    displayArea.append("Capitaine : " + capitaine + "\n");
    displayArea.append("Équipiers : " + equipage.getMarins() + "\n");
}


    public void saisirTemps() {
        if (course == null || course.getParticipants().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun bateau inscrit pour saisir les temps.");
            return;
        }

        for (Bateau bateau : course.getParticipants()) {
            double temps = Double.parseDouble(JOptionPane.showInputDialog(this, "Temps pour le bateau " + bateau.getNom() + " :"));
            bateau.enregistrerTemps(temps);
            displayArea.append("Temps enregistré pour le bateau " + bateau.getNom() + " : " + temps + " minutes\n");
        }
    }

    public void afficherResultats() {
        if (course == null) {
            JOptionPane.showMessageDialog(this, "Veuillez d'abord créer une course.");
            return;
        }

        course.trouverGagnants();

        displayArea.append("\n=== Résultats ===\n");
        for (Bateau bateau : course.getParticipants()) {
            displayArea.append(bateau.resultat() + "\n");
        }

        displayArea.append("\n=== Gagnants ===\n");
        for (Bateau gagnant : course.getGagnants()) {
            displayArea.append(gagnant.getNom() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IHMCourse ihm = new IHMCourse();
            ihm.setVisible(true);
        });
    }
}
