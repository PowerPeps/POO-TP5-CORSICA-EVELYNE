import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String titre;
    private List<Bateau> participants;
    private List<Bateau> gagnants;

    public Course(String titre) {
        this.titre = titre;
        this.participants = new ArrayList<>();
        this.gagnants = new ArrayList<>();
    }

    public List<Bateau> getParticipants() {
        return participants;
    }

    public List<Bateau> getGagnants() {
        return gagnants;
    }

    public void inscrireBateau(Bateau b, Equipage e) {
        b.affecterEquipage(e);
        participants.add(b);
    }

    public void trouverGagnants() {
        double tempsMin = participants.stream()
                                      .mapToDouble(Bateau::getTempsPondere)
                                      .min()
                                      .orElse(Double.MAX_VALUE);

        gagnants = participants.stream()
                               .filter(b -> b.getTempsPondere() == tempsMin)
                               .collect(Collectors.toList());
    }

    public void afficherGagnants() {
        if (gagnants.isEmpty()) {
            System.out.println("Aucun gagnant n'a été déterminé.");
        } else if (gagnants.size() == 1) {
            System.out.println("Le grand gagnant est " + gagnants.get(0).getNom());
        } else {
            System.out.print("Il y a " + gagnants.size() + " gagnants ex-aequo : ");
            gagnants.forEach(b -> System.out.print(b.getNom() + " "));
            System.out.println();
        }
    }

    public void afficherResultats() {
        if (participants.isEmpty()) {
            System.out.println("Aucun résultat à afficher, aucun participant.");
        } else {
            System.out.println("Résultats de la course " + this.titre + " :");
            for (Bateau b : participants) {
                String resultat = "Le bateau " + b.getNom() +
                                  " de " + b.getEquipage().getCapitaine().getNom() +
                                  " (barreur) a réalisé un temps pondéré de " +
                                  String.format("%.2f", b.getTempsPondere()) + " mn.";
                System.out.println(resultat);
            }
        }
    }
}
