package interfaces;

import java.util.List;
import model.Utilisateur;

public interface AuthentificationService {
    public Utilisateur register();
    public String generateCode();
    public String sendCode(String code);
    public boolean validate(List<Utilisateur> users);
    public Utilisateur connexion(List<Utilisateur> users);
    public Utilisateur deconnexion(Utilisateur u);
}
