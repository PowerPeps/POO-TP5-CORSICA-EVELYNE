
import java.util.Scanner;

public class IHMCourse {
    private Scanner scanner = new Scanner(System.in);

    public Equipier creerEquipier() {
        System.out.print("Nom de l'équipier : ");
        String nom = scanner.nextLine();
        System.out.print("Spécialité de l'équipier : ");
        String specialite = scanner.nextLine();
        return new Equipier(nom, specialite);
    }

    public Equipage creerEquipage() {
        System.out.print("Nom du capitaine : ");
        Equipier capitaine = creerEquipier();
        Equipage equipage = new Equipage(capitaine);
        System.out.print("Nombre de marins : ");
        int nbMarins = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nbMarins; i++) {
            equipage.ajoutEquipier(creerEquipier());
        }
        return equipage;
    }

    public Bateau creerBateau() {
        System.out.print("Nom du bateau : ");
        String nom = scanner.nextLine();
        System.out.print("Type du bateau (1 = MonoCoque, 2 = MultiCoque) : ");
        int type = Integer.parseInt(scanner.nextLine());
        return type == 1 ? new MonoCoque(nom) : new MultiCoque(nom);
    }
}
