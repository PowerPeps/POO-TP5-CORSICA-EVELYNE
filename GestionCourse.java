/*
public class GestionCourse {
    public static void main(String[] args) {
        // Création des bateaux
        Bateau monocoqueJava = new MonoCoque("Java");
        Bateau multicoqueTango = new MultiCoque("Tango");

        // Création des équipiers
        Equipier jean = new Equipier("Jean", "barreur");
        Equipier pierre = new Equipier("Pierre", "barreur");
        Equipier marie = new Equipier("Marie", "mousse");

        // Création des équipages
        Equipage fineEquipe = new Equipage(jean);
        fineEquipe.ajoutEquipier(marie);

        Equipage solitaire = new Equipage(pierre);

        // Création de la course
        Course courseDuVent = new Course("Course du vent");

        // Inscription des bateaux à la course
        courseDuVent.inscrireBateau(monocoqueJava, fineEquipe);
        courseDuVent.inscrireBateau(multicoqueTango, solitaire);

        // Enregistrement des temps
        monocoqueJava.enregistrerTemps(120); // 120 minutes pour Java
        multicoqueTango.enregistrerTemps(150); // 150 minutes pour Tango

        // Déterminer les gagnants
        courseDuVent.trouverGagnants();

        // Afficher les résultats
        System.out.println("=== Résultats de la course ===");
        courseDuVent.afficherResultats();

        // Afficher les gagnants
        System.out.println("=== Gagnant(s) ===");
        courseDuVent.afficherGagnants();
    }
}
*/
