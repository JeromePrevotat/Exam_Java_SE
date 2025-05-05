package ui;

import java.util.Scanner;
import model.BorneRecharge;
import model.LieuRecharge;
import model.Reservation;
import model.Utilisateur;
import services.Authentification;

public class App {
    public static void main(String[] args) throws Exception {
        // tests();

        run();
    }

    private static void run(){
        Menu menu = new Menu();
        Authentification auth = new Authentification();
        int choice;
        String userInput;

        try (Scanner scan = new Scanner(System.in)){
            menu.displayMenu(0);
            while (!menu.isExit()) {
                // L'utilisateur fait un choix
                userInput = scan.nextLine();
                choice = Integer.parseInt(userInput.trim());
                // Affichage du menu correspondant
                menu.displayMenu(choice);
                switch (choice) {
                    case 1:
                        Utilisateur u = auth.register();
                        System.out.println(u.toString());                    
                        break;
                    case 2:

                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Choix Invalide\n");
        }
    }

    private static void tests(){
        Utilisateur u0 = new Utilisateur();
        BorneRecharge b0 = new BorneRecharge();
        LieuRecharge l0 = new LieuRecharge();
        Reservation r0 = new Reservation();

        
        System.out.println("\n" + u0.toString());
        System.out.println("\n" + b0.toString());
        System.out.println("\n" + l0.toString());
        System.out.println("\n" + r0.toString());

        Menu menu = new Menu();
        menu.displayMenu(0);
    }
}
