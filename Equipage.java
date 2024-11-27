import java.util.ArrayList;
import java.util.List;

public class Equipage {
    private Equipier capitaine;
    private List<Equipier> marins;
    private int nbEquipiers;

    private static final int MAX_EQUIPIERS = 6;

    public Equipage(Equipier capitaine) {
        this.capitaine = capitaine;
        this.marins = new ArrayList<>();
        this.nbEquipiers = marins.size();
    }

    public Equipier getCapitaine() {
        return capitaine;
    }

    public void ajoutEquipier(Equipier e) {
        if (marins.size() < MAX_EQUIPIERS) {
            marins.add(e);
            this.nbEquipiers = marins.size();
        } else {
            System.out.println("Impossible d'ajouter l'équipier : limite maximale de " + MAX_EQUIPIERS + " atteinte.");
        }
    }

    public List<Equipier> getMarins() {
        return marins;
    }
}
