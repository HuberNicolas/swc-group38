import java.util.ArrayList;

public class SectionChief extends Employee{
    private String City;

    public SectionChief(String name, String surname, String city) {
        super(name, surname);
        this.City = city;
        //this.CustomerList = new ArrayList<Customer>();
        this.CustomerList = super.setCustomerList();
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

    void downgradeGoldToReg(Customer c) { // given the customer ID

    }
    void upgradeGoldToPlat(Customer c) {

    }
}
