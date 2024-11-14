
public class MultiCoque extends Bateau {
    private static final int COEFFICIENT = 5;

    public MultiCoque(String nom) {
        super(nom);
    }

    @Override
    public double getTempsPondere() {
        return super.temps * COEFFICIENT;
    }
}
