
public class GestionCourse {
    public static void main(String[] args) {
        // Création des bateaux
        MonoCoque java = new MonoCoque("Java");
        MultiCoque tango = new MultiCoque("Tango");

        // Création des équipiers
        Equipier jean = new Equipier("Jean", "barreur");
        Equipier pierre = new Equipier("Pierre", "barreur");
        Equipier marie = new Equipier("Marie", "mousse");

        // Création des équipages
        Equipage fineEquipe = new Equipage(jean);
        fineEquipe.ajoutEquipier(marie);
        Equipage solitaire = new Equipage(pierre);

        // Création de la course
        Course courseDuVent = new Course("Course du Vent");

        // Inscription des bateaux
        courseDuVent.inscrireBateau(java, fineEquipe);
        courseDuVent.inscrireBateau(tango, solitaire);

        // Enregistrement des temps
        java.enregistrerTemps(120);
        tango.enregistrerTemps(150);

        // Déterminer et afficher les résultats
        courseDuVent.trouverGagnants();
        courseDuVent.afficherGagnants();
    }
}
