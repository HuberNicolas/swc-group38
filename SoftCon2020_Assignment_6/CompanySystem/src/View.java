/**
 * View Class for the MCVPattern
 * Blueprint for the View entity
 */
public class View {
    /**
     * @param e = employee
     * description: methods prints attributes of the employee e
     *              (main purpose of the view entity)
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
