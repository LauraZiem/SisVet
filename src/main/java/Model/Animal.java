package Model;

/*
    As classes modelo, são conhecidas como 
    classes POJO - Plain Old Java Objects ou
            POCO - Plain Old C(++/#) Objects
*/

public class Animal {
    private int Id;
    private String Name;
    private String Type;
    private String Color;
    private double Size;
    private double Weight;
    private int Age;
    private int BirthMonth;

    public Animal() {
    }

    public Animal(int Id, String Name, String Type, String Color, double Size, double Weight, int Age, int BirthMonth) {
        this.Id = Id;
        this.Name = Name;
        this.Type = Type;
        this.Color = Color;
        this.Size = Size;
        this.Weight = Weight;
        this.Age = Age;
        this.BirthMonth = BirthMonth;
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

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public double getSize() {
        return Size;
    }

    public void setSize(double Size) {
        this.Size = Size;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getBirthMonth() {
        return BirthMonth;
    }

    public void setBirthMonth(int BirthMonth) {
        this.BirthMonth = BirthMonth;
    }
}