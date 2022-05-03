package Model;

import java.util.Date;

public class Attendance {
    private int Id;
    private Date DateAttendance;
    private Animal Animal;
    private Vet Vet;
    private String Details;

    public Attendance() {
    }

    public Attendance(int Id, Date DateAttendance, Animal Animal, Vet Vet, String Details) {
        this.Id = Id;
        this.DateAttendance = DateAttendance;
        this.Animal = Animal;
        this.Vet = Vet;
        this.Details = Details;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getDateAttendance() {
        return DateAttendance;
    }

    public void setDateAttendance(Date DateAttendance) {
        this.DateAttendance = DateAttendance;
    }

    public Animal getAnimal() {
        return Animal;
    }

    public void setAnimal(Animal Animal) {
        this.Animal = Animal;
    }

    public Vet getVet() {
        return Vet;
    }

    public void setVet(Vet Vet) {
        this.Vet = Vet;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }
}