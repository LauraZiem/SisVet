package Controller;

import Data.DataSetClinic;
import Model.Vet;
import java.util.ArrayList;

public class VetController implements IVetController{

    @Override
    public void insertVet(int idClinic, Vet vet) {
        DataSetClinic.data.get(idClinic).getVets().add(vet);
    }

    @Override
    public Vet updateVet(int idClinic, Vet vet) {
        return null;
    }

    @Override
    public Vet deleteVet(int idClinic, Vet vet) {
        DataSetClinic.data.get(idClinic).getVets().remove(vet);
        return vet;
    }

    @Override
    public Vet searchVet(int idClinic, int idVet) {
        Vet retorno = null;
 
        for(Vet v : DataSetClinic.data.get(idClinic).getVets()){
            if(v.getId() == idVet){
                retorno = v;
                break;
            }
        }
        
        return retorno;
    }

    @Override
    public ArrayList<Vet> searchVet(int idClinic, String name) {
        ArrayList<Vet> listReturn = new ArrayList<Vet>();
        
        for(Vet v : DataSetClinic.data.get(idClinic).getVets()){
            if(v.getName().toLowerCase().contains(name.toLowerCase())){
                listReturn.add(v);
            }
        }
        
        return listReturn;
    }
    
    public int getNextId(int idClinic){
        int retorno = 0;
        for(Vet a : DataSetClinic.data.get(idClinic).getVets()){
            if(a.getId()>retorno){
                retorno = a.getId();
            }
        }
        return(retorno + 1);
    }
}
