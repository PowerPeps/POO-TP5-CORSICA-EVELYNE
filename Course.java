
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String titre;
    private List<Bateau> participants;
    private List<Bateau> gagnants;

    public Course(String titre) {
        this.titre = titre;
        this.participants = new ArrayList<>();
        this.gagnants = new ArrayList<>();
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
        for (Bateau b : participants) {
            if (b.getTempsPondere() == tempsMin) {
                gagnants.add(b);
            }
        }
    }

    public void afficherGagnants() {
        if (gagnants.size() == 1) {
            System.out.println("Le grand gagnant est " + gagnants.get(0).getNom());
        } else {
            System.out.print("Il y a " + gagnants.size() + " gagnants ex-aequo : ");
            gagnants.forEach(b -> System.out.print(b.getNom() + " "));
        }
        System.out.println();
    }
}
