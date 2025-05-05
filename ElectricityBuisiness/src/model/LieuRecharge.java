package model;

import java.util.List;

public class LieuRecharge {
    private int id;
    private String nom;
    private String adresse; //Class ?
    private List<BorneRecharge> bornes;


    public LieuRecharge() {}

    public LieuRecharge(int id, String nom, String adresse, List<BorneRecharge> bornes){
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.bornes = bornes;
    }

    // GETTER
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public List<BorneRecharge> getBornes() {
        return this.bornes;
    }

    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setBornes(List<BorneRecharge> bornes) {
        this.bornes = bornes;
    }

    // METHODS
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lieu de Recharge ").append(this.id).append(" ===").append("\n")
            .append("Nom: ").append(this.nom).append("\n")
            .append("Adresse: ").append(this.adresse).append("\n")
            .append("Bornes: ").append(this.bornes.toString()).append("\n");
        return sb.toString();
    }

}
