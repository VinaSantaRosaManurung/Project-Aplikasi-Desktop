package b_interface;

import a_entitas.MuridBaru;
import javafx.collections.ObservableList;

public interface MuridBaru_Interface {
  MuridBaru insert(MuridBaru mrd)throws Exception;  
  void update(MuridBaru mrd)throws Exception;
  void delete(String waktu)throws Exception;
  ObservableList<MuridBaru> getAll()throws Exception;
}
