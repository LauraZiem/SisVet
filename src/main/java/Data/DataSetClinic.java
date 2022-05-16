package Data;

import Model.Clinic;
import java.util.ArrayList;

public abstract class DataSetClinic {
    //Coleção de clinicas cadastradas o sistema
    public static ArrayList<Clinic> data = new ArrayList<Clinic>();
    /*
        Propriedade estática que será utilizada para identificar qual a 
        clinica selecionada pelo usuário para operações no sistema
    */
    public static Clinic selectedClinic;
}
