public class View {
    /**
     *
     * @param e = employee
     */
    public void printEmpolyeeDetails(Employee e) {
        printName(e.getName());
        printSurname(e.getSurname());
        printAddress(e.getAddress());
        printPhoneNumber(e.getPhoneNumber());
        printId(e.getId());
    }

    //methods to print out
    public void printName(String name) {
        System.out.println(name);
    }
    public void printSurname(String surname) {
        System.out.println(surname);
    }
    public void printAddress(String address) {
        System.out.println(address);
    }
    public void printPhoneNumber(int phoneNumber) {
        System.out.println(phoneNumber);
    }
    public void printId(int id) {
        System.out.println(id);
    }

}
