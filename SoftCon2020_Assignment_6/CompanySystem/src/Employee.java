/**
 * Class Employee models a employee entity
 */
public class Employee {
    private String name;        // eg. John
    private String surname;     // eg. Doe
    private String address;     // eg. Lake Placid 31
    private int phoneNumber;    // eg. 797681947 (9 digits)
    private int id;             // eg. 12345678 (8 digits)

    // Getter and Setter

    // Getter
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    // Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
}
