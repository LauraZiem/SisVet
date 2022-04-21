package Model;

public class Vet {
    private int Id;
    private String Name;
    private String CRV;

    public Vet() {
    }

    public Vet(int Id, String Name, String CRV) {
        this.Id = Id;
        this.Name = Name;
        this.CRV = CRV;
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

    public String getCRV() {
        return CRV;
    }

    public void setCRV(String CRV) {
        this.CRV = CRV;
    }
}
