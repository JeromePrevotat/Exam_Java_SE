package interfaces;

import java.util.List;
import model.BorneRecharge;

public interface BorneService {
    public List<BorneRecharge> getAll();
    public List<BorneRecharge> getContainAdresse(String adresse);
    public List<BorneRecharge> getExactAdresse(String addresse);
}
