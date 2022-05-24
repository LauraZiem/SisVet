package Controller;

import Model.Clinic;
import Data.DataSetClinic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClinicController implements IClinicController{
    
    @Override
    public void insertClinic(Clinic clinic) {
        DataSetClinic.data.add(clinic);
    }

    @Override
    public Clinic updateClinic(Clinic clinic) {
        return null;
    }

    @Override
    public Clinic deleteClinic(Clinic clinic) {
        DataSetClinic.data.remove(clinic);
        return clinic;
    }

    @Override
    public Clinic searchClinic(int id) {
        Clinic retorno = null;
        //Método mais fácil de fazer o FOR (Tipado)
        for(Clinic c : DataSetClinic.data){
            if(c.getId() == id){
                retorno = c;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Clinic searchClinic(String name) {
        Clinic retorno = new Clinic();
        //Médoto Detalhado/Clássico de fazer o FOR
        for(int i = 0; i < DataSetClinic.data.size(); i++){
            if(DataSetClinic.data.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                retorno = DataSetClinic.data.get(i);
                break;
            }
        }
        return retorno;
    }
    
    public int getNextId(){
        int id = 0;
        
        for(Clinic c : DataSetClinic.data){
            if(c.getId()>id)
                id = c.getId();
        }
        
        return (id + 1);
    }
    
    public int getClinicIndex(int idClinic){
        return DataSetClinic.data.indexOf(searchClinic(idClinic));
    }
    
    public void exportData(){
        System.out.println("LOG: GERANDO ARQUIVO...");
        File arquivo = new File("exportClinics.txt");
        
        String line = "";
        for (Clinic c : DataSetClinic.data){
            line += c.getId() + ";" + 
                    c.getName() + "\n";
        }
        
        try{
            FileOutputStream fos = new FileOutputStream(arquivo);
            fos.write(line.getBytes());
            fos.close();
            System.out.println("LOG: ARQUIVO GERADO COM SUCESSO!");
        }catch(Exception ex){
            System.out.println("LOG: OCORREU UM ERRO...");
            System.out.println(ex.getMessage());
        }
    }
    
    public void importData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ATENÇÃO: INFORME O NOME DO ARQUIVO.TXT");
        String fileName =  sc.nextLine();
        
        try{
            FileReader arq = new FileReader(fileName);
            BufferedReader lerArq = new BufferedReader(arq);
            String line = lerArq.readLine();
            while(line != null){
                String[] data = line.split(";");
                Clinic clinic = new Clinic(Integer.parseInt(data[0]), data[1]);
                
                this.insertClinic(clinic);
                
                line = lerArq.readLine();
            }
            arq.close();
        }catch(IOException ex){
            System.out.println("Erro ao tentar ler o arquivo.");
            System.out.println(ex.getMessage());
        }
    }
}