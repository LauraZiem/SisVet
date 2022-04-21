package Model;

import java.util.ArrayList;

public class Clinic {
    private int Id;
    private String Name;
    private ArrayList<Vet> Vets =  new ArrayList<Vet>();
    private ArrayList<Animal> Animals = new ArrayList<Animal>();
    private ArrayList<Attendance> Attendaces = new ArrayList<Attendance>();

    public Clinic() {
    }

    public Clinic(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Vet> getVets() {
        return Vets;
    }

    public void setVets(ArrayList<Vet> Vets) {
        this.Vets = Vets;
    }

    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> Animals) {
        this.Animals = Animals;
    }

    public ArrayList<Attendance> getAttendaces() {
        return Attendaces;
    }

    public void setAttendaces(ArrayList<Attendance> Attendaces) {
        this.Attendaces = Attendaces;
    }
}
