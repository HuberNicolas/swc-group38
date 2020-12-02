public class Employee {
    private String name;
    private String surname;
    private String address;
    private int phoneNumber; // eg. 797681947 (9 digits)
    private int id; // eg. 12345678 (8 digits)

    // Getter and Setter

    public String getName() { return name;}
    public String getSurname() { return surname;}
    public String getAddress() { return address;}
    public int getPhoneNumber() { return phoneNumber;}
    public int getId() { return id;}

    public void setName(String name) { this.name = name;}
    public void setSurname(String surname) { this.surname = surname;}
    public void setAddress(String address) { this.address = address;}
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber;}
    public void setId(int id) { this.id = id;}


}
