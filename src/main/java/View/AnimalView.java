package View;

import Data.DataSetClinic;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Animal;
import Model.Vet;
import Controller.AnimalController;
import Controller.ClinicController;

public class AnimalView {
    private int iClinic;
    private Animal animal = new Animal();
    private AnimalController animalController = new AnimalController();
    private ClinicController clinicController = new ClinicController();
    private Scanner sc = new Scanner(System.in);

    public AnimalView() {
        this.InitiView();
    }
    
    private void InitiView(){
        System.out.println("********");
        System.out.println("ANIMAIS:");
        System.out.println("********");
        System.out.println("");
        
        System.out.println(DataSetClinic.selectedClinic.getAnimals().size() + " Animais cadastrados.\n");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            
            System.out.println("1- Incluir Animal");
            System.out.println("2- Listar Animais");
            System.out.println("0- Sair");
            
            op = sc.nextInt();
            
            switch(op){
                case 1:
                    this.InsertAnimal();
                    break;
                case 2:
                    this.ListAnimals();
                    break;
                case 0: 
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(op != 0);
    }
    
    private void InsertAnimal(){
        System.out.println("********************");
        System.out.println("INSERIR NOVO ANIMAL:");
        System.out.println("********************");
        
        Animal animal = new Animal();
        
        int iClinic = 0;
        this.clinicController.getClinicIndex(DataSetClinic.selectedClinic.getId());
        
        animal.setId(this.animalController.getNextId(iClinic));
        
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        nome = sc.nextLine();
        animal.setName(nome);
        
        System.out.println("Tipo: ");
        String tipo = sc.nextLine();
        animal.setType(tipo);
        
        System.out.println("Cor: ");
        String cor = sc.nextLine();
        animal.setColor(cor);
        
        System.out.println("Tamanho: ");
        Double tamanho = Double.parseDouble(sc.nextLine());
        animal.setSize(tamanho);
        
        System.out.println("Peso: ");
        Double peso = Double.parseDouble(sc.nextLine());
        animal.setWeight(peso);
        
        System.out.println("Idade: ");
        Integer idade = Integer.parseInt(sc.nextLine());
        animal.setAge(idade);
        
        System.out.println("Mês Nascimento: ");
        Integer mesNascimento = Integer.parseInt(sc.nextLine());
        animal.setBirthMonth(mesNascimento);
        
        this.animalController.insertAnimal(iClinic, animal);
    }
    
    private void ListAnimals(){
        ArrayList<Animal> animals = this.animalController.getAnimals(iClinic);
        
        for(Animal a : animals){
            System.out.println("Nome: " + a.getName());
            System.out.println("Tipo: " + a.getType());
            System.out.println("Cor: " + a.getColor());
            System.out.println("Tamanho: " + a.getSize());
            System.out.println("Peso: " + a.getWeight());
            System.out.println("Idade: " + a.getAge());
            System.out.println("Mês Nascimento: " + a.getBirthMonth());
            System.out.println(System.lineSeparator());
        }
    }
}
