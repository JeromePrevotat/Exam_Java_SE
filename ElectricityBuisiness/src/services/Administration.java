package services;

import interfaces.AdministrationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.BorneRecharge;
import model.LieuRecharge;

public class Administration implements AdministrationService{
    private final Scanner scan = new Scanner(System.in);
    private List<LieuRecharge> lieux;

    public Administration(List<LieuRecharge> lieux) {
        this.lieux = lieux;
    }

    public Scanner getScan() {
        return this.scan;
    }

    @Override
    public boolean addNewLieu(){
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
        return this.lieux.add(new LieuRecharge(nom, adresse, listBornes));
    }

    @Override
    public LieuRecharge selectLieu(){
        String userInput = "";
        String filter = "";
        while (!userInput.equals("0")) {       
            // Type de recherche     
            System.out.println("=== Selection d'un lieu ===\n");
            while (!userInput.equals("0") && !userInput.equals("N") && !userInput.equals("A")){
                System.out.println("Chercher par Nom (N) ou Adresse (A) ? ");
                userInput = this.scan.next().trim().toUpperCase();
            }
            filter = userInput;
            userInput = "";
            // Filter
            while (userInput.equals("")){
                if (filter.equals("A")) System.out.print("Saisisser l'Adresse: ");
                if (filter.equals("N")) System.out.print("Saisisser le Nom: ");
                userInput = this.scan.next().trim();
            }
            for (LieuRecharge l : this.lieux){
                // Recherche par Nom
                if (filter.equals("N") && l.getNom().contains(userInput)) return l;
                // Recherche par Adresse
                else if (filter.equals("A") && l.getAdresse().contains(userInput)) return l;
                // Aucun filtre correspondant, retourne tous les lieux
                else System.out.println("Aucun lieu correspondant aux critères.\n Entrer 0 pour en ajouter un nouveau.");
            }
            userInput = "";
        }
        return null;
    }

    @Override
    public boolean addNewBorne(){
        String input = "";
        double tarifHoraire = 0;
        // Choix d'un lieu sur lequel ajouter une borne
        LieuRecharge lieu = selectLieu();
        while (lieu == null) {
            addNewLieu();
            lieu = selectLieu();
        }
        while (input.trim().equals("") || tarifHoraire <= 0){
            System.out.println("Entrer le tarif de la Borne: ");
            input = this.scan.next().trim();
            try {
                tarifHoraire = Double.valueOf(input);   
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        return lieu.getBornes().add(new BorneRecharge(tarifHoraire));
    }
}
