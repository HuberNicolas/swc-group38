public abstract class Technician extends Person{

    Technician(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
        this.ID = Utils.generateID();
    }
}
