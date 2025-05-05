package services;

import java.util.ArrayList;
import java.util.List;

import model.Utilisateur;

public class Users {
    private List<Utilisateur> users = new ArrayList<>();

    public Users() {}

    public List<Utilisateur> getUsers() {
        return this.users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    
}
