
import java.util.ArrayList;
import java.util.List;

public class Equipage {
    private Equipier capitaine;
    private List<Equipier> marins;

    public Equipage(Equipier capitaine) {
        this.capitaine = capitaine;
        this.marins = new ArrayList<>();
    }

    public Equipier getCapitaine() {
        return capitaine;
    }

    public void ajoutEquipier(Equipier e) {
        marins.add(e);
    }

    public List<Equipier> getMarins() {
        return marins;
    }
}
