
public class MonoCoque extends Bateau {
    private static final int COEFFICIENT = 2;

    public MonoCoque(String nom) {
        super(nom);
    }

    @Override
    public double getTempsPondere() {
        return super.temps * COEFFICIENT;
    }
}
