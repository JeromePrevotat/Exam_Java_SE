package interfaces;

import model.BorneRecharge;
import model.LieuRecharge;

public interface AdministrationService {
    public boolean addNewLieu();
    public LieuRecharge selectLieu();
    public boolean addNewBorne();

}
