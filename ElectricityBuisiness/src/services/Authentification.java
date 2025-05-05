package services;

import interfaces.AuthentificationService;
import java.util.List;
import java.util.Scanner;
import model.Utilisateur;

public class Authentification implements AuthentificationService{
    private final int MAX_ATTEMPS = 3;
    private final Scanner scan = new Scanner(System.in);
    
    @Override
    public Utilisateur register() {
        String username = askUsername();
        String email = askEmail();
        String password = askPassword();
        String code = generateCode();
        System.out.println(sendCode(code));
        return new Utilisateur(username, email, password, code);
    }

    public String askPassword() {
        String password = null;
        while (password == null || password.trim().equals("")){
            System.out.println("Entrer votre mot de passe: ");
            password = this.scan.next().trim();
        }
        return password;
    }

    public String askEmail() {
        String email = null;
        while (email == null || email.trim().equals("")){
            System.out.println("Entrer votre adresse mail: ");
            email = scan.next().trim();
        }
        return email;
    }

    public String askUsername() {
        String username = null;
        while (username == null || username.trim().equals("")){
            System.out.println("Entrer votre nom d'utilisateur: ");
            username = scan.next().trim();
        }
        return username;
    }

    @Override
    public String generateCode() {
        String code = "";
        int i = 0;
        while (i < 4){
            // Genere un chiffre entre 0 et 9
            int digit = (int) (Math.random() * 10);
            code += digit;
            i++;
        }
        return code;
    }

    @Override
    public boolean validate(List<Utilisateur> users) {
        int attempts = 0;
        String email = askEmail();
        String password = askPassword();

        System.out.println("=== Electricity Buisiness ===");
        for (Utilisateur u : users){
            if (email.equals(u.getEmail()) && password.equals(u.getMotDePasse())){
                while (attempts < MAX_ATTEMPS){
                    System.out.print("Veuillez entrer votre code de confirmation: ");
                    if (this.scan.next().trim().equals(u.getCodeValidation())){
                        u.setEstValide(true);
                        return true;
                    }
                    else System.out.println("Code Invalide. " + (MAX_ATTEMPS - 1 - attempts) + " Tentatives restantes.");
                    attempts++;
                }
            }
        }
        return false;
    }

    @Override
    public boolean connexion(List<Utilisateur> users) {
        String email = askEmail();
        String password = askPassword();
        for (Utilisateur u : users){
            if (email.equals(u.getEmail()) && password.equals(u.getMotDePasse())){
                u.setLogged(true);
                return u.isLogged();
            }
        }
        return false;
    }

    @Override
    public boolean deconnexion(Utilisateur u) {
        if (u.isLogged()){
            u.setLogged(false);
            return true;
        }
        return false;
    }

    @Override
    public String sendCode(String code) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Buisiness ===").append("\n")
            .append("Votre Code de confirmation: ").append(code).append("\n");
        return sb.toString();
    }

}
