package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilisateur {
    private static int idTotal = 0;
    private final Scanner scan = new Scanner(System.in);
    private int id;
    private String username;
    private String email;
    private String motDePasse;
    private String codeValidation;
    private boolean estValide;
    private boolean isLogged;

    public Utilisateur() { idTotal++; }
    
    public Utilisateur(String username, String email, String motDePasse, String codeValidation){
        this.id = idTotal;
        this.username = username;
        this.email = email;
        this.motDePasse = motDePasse;
        this.codeValidation = codeValidation;
        this.estValide = false;
        this.isLogged = false;
        idTotal++;
    }

    // GETTER
    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getCodeValidation() {
        return this.codeValidation;
    }

    public boolean isEstValide() {
        return this.estValide;
    }

    public boolean isLogged() {
        return this.isLogged;
    }

    // SETTER
    public void setId(int id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    // METHODS
    public LieuRecharge addNewLieu(){
        String nom = null;
        String adresse = null;
        List<BorneRecharge> listBornes = new ArrayList<>();
        while (nom == null || nom.trim().equals("")){
            System.out.println("Entrer un nom pour le Lieu: ");
            nom = this.scan.next().trim();
        }
        while (adresse == null || adresse.trim().equals("")){
            System.out.println("Entrer l'Adresse du Lieu: ");
            adresse = this.scan.next().trim();
        }
        return new LieuRecharge(nom, adresse, listBornes);
    }

    public BorneRecharge addNewBorne(){
        String input = "";
        double tarifHoraire = 0;
        while (input.trim().equals("") || tarifHoraire <= 0){
            System.out.println("Entrer le tarif de la Borne: ");
            input = this.scan.next().trim();
            try {
                tarifHoraire = Double.valueOf(input);   
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        return new BorneRecharge(tarifHoraire);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Utilisateur ").append(this.id).append(" ===").append("\n")
            .append("Username: ").append(this.username).append("\n")
            .append("Email: ").append(this.email).append("\n")
            /*********
             * DEBUG *
            **********/
            .append("PWD: ").append(this.motDePasse).append("\n")
            .append("CODE: ").append(this.codeValidation).append("\n")
            .append("VALID: ").append(this.estValide).append("\n");
            /*********
             * DEBUG *
            **********/
        return sb.toString();
    }    
}
