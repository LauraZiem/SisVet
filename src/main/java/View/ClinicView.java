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
            
            op = sc.nextInt();
            
            switch(op){
                case 1:
                    this.InsertClinic();
                    break;
                case 2:
                    this.SelectClinic();
                    break;
                case 0:
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
        int op = 0;
        do{
            System.out.println("********************************");
            System.out.println("Qual o id da clínica?");
            int id = sc.nextInt();
            
        }while(op == 0);
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
}
