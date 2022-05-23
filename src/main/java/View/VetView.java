package View;

import Data.DataSetClinic;
import java.util.Scanner;
import Model.Vet;
import Controller.VetController;
import Controller.ClinicController;

public class VetView {
    private Vet vet = new Vet();
    private VetController vetController = new VetController();
    private Scanner sc = new Scanner(System.in);
    
    public VetView(){
        this.InitVetView();
    }
    
    public VetView(int indexClinic){
        DataSetClinic.data.get(indexClinic).getVets().add(new Vet(1, "Mauricio", "123456"));
        DataSetClinic.data.get(indexClinic).getVets().add(new Vet(2, "Roberto", "246810"));
        
        this.InitVetView();
    }
    
    private void InitVetView(){
        System.out.println("****************");
        System.out.println("MENU VETERINÁRIO");
        System.out.println("****************");
        
        System.out.println(DataSetClinic.selectedClinic.getVets().size() + " Veterinários cadastrados. \n");
        
        int op = 0;
        do{
            System.out.println("********");
            System.out.println("MENU VET");
            System.out.println("********");
            
            System.out.println("1 - Incluir Veterinário");
            System.out.println("2 - Selecionar Veterinário");
            System.out.println("0 - SAIR");
            
            op = Integer.parseInt(sc.nextLine());
            
            switch(op){
                case 1:
                    this.InsertVet();
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }while(op != 0);
    }
    
    private void InsertVet(){
        System.out.println("*************************");
        System.out.println("Inserir novo Veterinário:");
        System.out.println("*************************");
        
        Vet newVet = new Vet();
        
        ClinicController clinicController = new ClinicController();
        int iClinic = clinicController.getClinicIndex(DataSetClinic.selectedClinic.getId());
        
        newVet.setId(this.vetController.getNextId(iClinic));
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("CRV: ");
        String srv = sc.nextLine();
        
        newVet.setName(nome);
        newVet.setCRV(srv);
        
        this.vetController.insertVet(iClinic, newVet);
        
        System.out.println("Veterinário " + newVet.getName() + " Incluido com sucesso!");
    }
}