package View;

import java.util.Scanner;
import Controller.ClinicController;
import Data.DataSetClinic;
import Model.Clinic;

public class ClinicView {
    private Scanner sc = new Scanner(System.in);
    private ClinicController clinicController = new ClinicController();
    
    /*
        Método contrutor da View de Clinica
        quando o view de clinica for instanciada, automaticamente,
        o método de inicialização será também invocada.
    */
    public ClinicView() {
        
        DataSetClinic.data.add(new Clinic(1, "Amigo do bicho"));
        DataSetClinic.data.add(new Clinic(2, "Pet Lovers"));
        
        this.InitClinicView();
    }
    
    private void InitClinicView(){
        System.out.println("***********************");
        System.out.println("**BEM-VINDO AO SISVET**");
        System.out.println("***********************");
        System.out.println("");
        
        System.out.println(DataSetClinic.data.size() + " clínicas cadastradas.");
        System.out.println("");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            System.out.println("");
            
            System.out.println("1- Incluir clínica");
            System.out.println("2- Selecionar clínica");
            System.out.println("0- SAIR");
            
            op = Integer.parseInt(sc.nextLine());
            
            switch(op){
                case 1:
                    this.InsertClinic();
                    break;
                case 2:
                    this.SelectClinic();
                    this.ShowMenuClinic();
                    break;
                case 0:
                    System.out.println("Encerrando Clínica...");
                    break;
                default:
                    System.out.println("**************");
                    System.out.println("Opção Inválida");
                    System.out.println("**************");
                    break;
            }
        }while (op != 0);
    }
    
    private void InsertClinic(){
        System.out.println("*********************");
        System.out.println("Inserir Nova Clínica:");
        System.out.println("*********************");
        
        Clinic newClinic = new Clinic();
        newClinic.setId(this.clinicController.getNextId());
        System.out.println("Nome:");
        String name = sc.nextLine();
        newClinic.setName(name);
        this.clinicController.insertClinic(newClinic);
    }
    
    private void SelectClinic(){
        int op = 0;
        do{
            System.out.println("******************************");
            System.out.println("Selecione o código da clínica:");
            System.out.println("******************************");
            for(Clinic c : DataSetClinic.data){
                System.out.println(c.getId() + " - " + c.getName());
            }
            op = sc.nextInt();
            DataSetClinic.selectedClinic = this.clinicController.searchClinic(op);
            
            if(DataSetClinic.selectedClinic == null){
                System.out.println("Clínica Inválida!!!");
                op = 0;
            }
        }while(op == 0);
    }
    
    private void ShowMenuClinic(){
        int opcao = 0;
        
        do{
            System.out.println("************");
            System.out.println("MENU CLÍNICA");
            System.out.println("************");
            
            System.out.println("Você está em CLÍNICA: " + 
                                DataSetClinic.selectedClinic.getId() + " - " + 
                                DataSetClinic.selectedClinic.getName());
            System.out.println("");
            
            System.out.println("1 - Veterinário");
            System.out.println("2 - Animal");
            System.out.println("3 - Atendimento");
            System.out.println("0 - SAIR");
            opcao = sc.nextInt();
            
            switch(opcao){
                case 1:
                    VetView vetView = new VetView(this.clinicController.getClinicIndex(DataSetClinic.selectedClinic.getId()));
                    break;
                case 2:
                    //Chamar view do animal
                    break;
                case 3:
                    //Chamar view do atendimento
                    break;
                case 0:
                    System.out.println("Saindo da clínica...");
                    break;
                default:
                    System.out.println("**************");
                    System.out.println("Opção Inválida");
                    System.out.println("**************");
                    opcao = 0;
                    break;
            }
        }while(opcao != 0);
    }
}