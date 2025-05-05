package services;

import java.util.ArrayList;
import java.util.List;

import interfaces.BorneService;
import model.BorneRecharge;
import model.EtatBorne;
import model.LieuRecharge;

public class Bornes implements BorneService{
    private List<LieuRecharge> lieux = new ArrayList<>();

    public Bornes(List<LieuRecharge> lieux) {
        this.lieux = lieux;
    }

    public List<LieuRecharge> getBornes() {
        return this.lieux;
    }
    
    public void setBornes(List<LieuRecharge> lieux) {
        this.lieux = lieux;
    }
    
    // METHODS
    /*
     * Method that returns every available Borne anywhere
     */
    @Override
    public List<BorneRecharge> getAll() {
        List<BorneRecharge> results = new ArrayList<>();
        for (LieuRecharge l : this.lieux){
            for (BorneRecharge b : l.getBornes()){
                if (b.getEtat() == EtatBorne.DISPONIBLE) results.add(b);
            }
        }
        return results;
    }

    /*
     * Method that returns every available Borne in any Lieux which Adresse contains a given String
     */
    @Override
    public List<BorneRecharge> getContainAdresse(String adresse) {
        List<BorneRecharge> results = new ArrayList<>();
        for (LieuRecharge l : this.lieux){
            if (l.getAdresse().contains(adresse)){
                for (BorneRecharge b : l.getBornes()){
                    if (b.getEtat() == EtatBorne.DISPONIBLE) results.add(b);
                }
            }
        }
        return results;
    }

    /*
     * Method that returns every available Borne in any Lieux whith a given Adresse
     */
    @Override
    public List<BorneRecharge> getExactAdresse(String adresse) {
        List<BorneRecharge> results = new ArrayList<>();
        for (LieuRecharge l : this.lieux){
            if (l.getAdresse().equals(adresse)){
                for (BorneRecharge b : l.getBornes()){
                    if (b.getEtat() == EtatBorne.DISPONIBLE) results.add(b);
                }
            }
        }
        return results;
    }

    /*
     * Method that returns every available Borne in any Lieux whith a given Name
     */
    @Override
    public List<BorneRecharge> getExactName(String nom) {
        List<BorneRecharge> results = new ArrayList<>();
        for (LieuRecharge l : this.lieux){
            if (l.getNom().equals(nom)){
                for (BorneRecharge b : l.getBornes()){
                    if (b.getEtat() == EtatBorne.DISPONIBLE) results.add(b);
                }
            }
        }
        return results;
    }


    
}
