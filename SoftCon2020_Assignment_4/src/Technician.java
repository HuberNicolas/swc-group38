/**
 * CLASS TECHNICIAN
 * base class for all entities of type TECHNICIAN
 * models an human entity of a TECHNICIAN
 */
public abstract class Technician extends Person{

    Technician(String name, String surname) {
        this.Name = name;               // eg. Locatelli
        this.Surname = surname;         // eg. Tabea
        this.ID = Utils.generateID();   // eg. 154
    }
}
