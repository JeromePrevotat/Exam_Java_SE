package ui;

public class Menu {
    private boolean exit = false;
    private TypesMenu toDisplay = TypesMenu.MAIN;
    private final String MENU_PRINCIPAL = initMenuPrincipal();
    private final String INSCRIPTION = initInscription();
    private final String VALIDATION = initValidation();
    private final String CONNEXION = initConnexion();
    private final String CHERCHER = initChercher();
    private final String GERER = initGerer();
    private final String ADMINISTRER = initAdministrer();
    private final String EXIT = initQuitter();

    public Menu(){}

    // GETTER
    public boolean isExit() {
        return this.exit;
    }

    public TypesMenu getToDisplay() {
        return this.toDisplay;
    }

    // SETTER
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void setToDisplay(TypesMenu toDisplay) {
        this.toDisplay = toDisplay;
    }

    // METHODS
    public void displayMenu(int menu){
        switch (menu) {
            case 1 -> {
                this.setToDisplay(TypesMenu.INSCRIPTION);
                System.out.println(INSCRIPTION);
            }
            case 2 -> {
                this.setToDisplay(TypesMenu.VALIDATION);
                System.out.println(VALIDATION);
            }
            case 3 -> {
                this.setToDisplay(TypesMenu.CONNEXION);
                System.out.println(CONNEXION);
            }
            case 4 -> {
                this.setToDisplay(TypesMenu.CHERCHER);
                System.out.println(CHERCHER);
            }
            case 5 -> {
                this.setToDisplay(TypesMenu.GERER);
                System.out.println(GERER);
            }
            case 6 -> {
                this.setToDisplay(TypesMenu.ADMINISTRER);
                System.out.println(ADMINISTRER);
            }
            case 0 -> {
                if (!this.isExit()){
                    this.setToDisplay(TypesMenu.MAIN);
                    System.out.println(MENU_PRINCIPAL);
                }
            }
        }
    }

    // CONSTANTS
    private static String initMenuPrincipal(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("1. S'inscrire").append("\n")
            .append("2. Valider l'inscription").append("\n")
            .append("3. Se connecter").append("\n")
            .append("4. Rechercher & réserver une borne").append("\n")
            .append("5. Gérer mes réservations").append("\n")
            .append("6. Administration (lieux / bornes)").append("\n")
            .append("0. Quitter").append("\n");
        return sb.toString();
    }

    private String initInscription(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Formulaire d'inscription ===").append("\n");
        return sb.toString();
    }

    private static String initValidation(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Validation d'inscription ===").append("\n");
        return sb.toString();
    }
    
    private static String initConnexion(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Connexion ===").append("\n");
        return sb.toString();
    }
    
    private static String initChercher(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Recherche & Reservation ===").append("\n");
        return sb.toString();
    }
    
    private static String initGerer(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Gestion des Reservations ===").append("\n");
        return sb.toString();
    }
    
    private static String initAdministrer(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("=== Administration des Lieux et Bornes ===").append("\n");
        return sb.toString();
    }

    private static String initQuitter(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Electricity Business ===").append("\n")
            .append("A Bientot !").append("\n");
        return sb.toString();
    }

}
