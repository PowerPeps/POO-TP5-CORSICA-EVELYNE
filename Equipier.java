
public class Equipier {
    private String nom;
    private String specialite;

    public Equipier(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public String toString() {
        return nom + "(" + specialite + ")";
    }
}
