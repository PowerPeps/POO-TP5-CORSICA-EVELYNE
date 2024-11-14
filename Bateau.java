
public abstract class Bateau {
    private String nom;
    private Equipage equipage;
    private double temps;

    public Bateau(String nom) {
        this.nom = nom;
    }

    public void enregistrerTemps(double temps) {
        this.temps = temps;
    }

    public void affecterEquipage(Equipage equipage) {
        this.equipage = equipage;
    }

    public abstract double getTempsPondere();

    public String resultat() {
        return "Le bateau " + nom + " de " + equipage.getCapitaine() +
               " a réalisé un temps pondéré de " + String.format("%.2f", getTempsPondere()) + " mn";
    }

    public String getNom() {
        return nom;
    }
}
