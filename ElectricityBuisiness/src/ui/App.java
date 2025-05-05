package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.LieuRecharge;
import model.Utilisateur;
import services.Authentification;
import services.Users;

public class App {
    public static void main(String[] args) throws Exception {
        tests();

        // run();
    }

    private static void run(){
        Menu menu = new Menu();
        Users users = new Users();
        System.out.println(users.getUsers());
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
                        if (u != null){
                            users.getUsers().add(u);
                            System.out.println("Inscription Terminée. Retour au Menu principal\n");
                        }
                        else System.out.println("Une Erreur est survenue... Retour au Menu Principal\n");
                        menu.displayMenu(0);
                        break;
                    case 2:
                        auth.validate(users.getUsers());
                        menu.displayMenu(0);
                        break;
                    case 3:
                        if(auth.connexion(users.getUsers())) System.out.println("Vous êtes connecté. Retour au Menu principal\n");
                        else System.out.println("Identifiants incorrects... Retour au Menu Principal\n");
                        menu.displayMenu(0);
                        break;
                    case 4:
                        menu.displayMenu(0);
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
        List<LieuRecharge> lieux = new ArrayList<>();
        Utilisateur u = new Utilisateur();
        // Creation d'un nouveau lieu de recharge
        lieux.add(u.addNewLieu());
        // Verif
        for (LieuRecharge l : lieux){
            System.out.println("LIEUX:\n");
            System.out.println(l.toString());
        }
        // Si la liste de lieux n'est pas vide on ajoute une borne a la liste du premier lieu
        if (!lieux.isEmpty()){
            lieux.getFirst().getBornes().add(u.addNewBorne());
        }
        // Verif
        System.out.println("BORNE:\n");
        System.out.println(lieux.getFirst().getBornes().stream().toString());
    }
}
