public class MainChief extends Employee{

    public MainChief(String name, String surname) {
        super(name, surname);
    }

    void upgradeRegToGold(Customer c) {
        super.upgradeRegToGold(c);
    }

    void addCustomer(Customer c) {
        super.addCustomer(c);
    }

    void printCustomerList(Employee e) {
        super.printCustomerList(e);
    }


    void downgrade(Customer c, String state) { // downgrade to state=gold or state=regular

    }
}
