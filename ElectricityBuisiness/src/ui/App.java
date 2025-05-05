package ui;

import model.BorneRecharge;
import model.LieuRecharge;
import model.Reservation;
import model.Utilisateur;

public class App {
    public static void main(String[] args) throws Exception {
        tests();
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
    }
}
