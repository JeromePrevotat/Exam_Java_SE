package interfaces;

import model.Utilisateur;

public interface AuthentificationService {
    public Utilisateur register();
    public String generateCode();
    public String sendCode(String code);
    public boolean validate(Utilisateur u);
    public boolean connexion();
    public boolean deconnexion();
}
