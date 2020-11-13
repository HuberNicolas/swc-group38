import java.util.ArrayList;

/**
 * CLASS SectionChief
 * base class for all entities of type EMPLOYEE
 * models an human entity of a SectionChief
 */
public class SectionChief extends Employee{
    private String City; // eg. Zurich

    // Constructor
    public SectionChief(String name, String surname, String city) {
        // use super constructor of Employee
        super(name, surname);
        this.City = city; // eg. Zurich
        //this.CustomerList = new ArrayList<Customer>();
        this.CustomerList = super.setCustomerList(); // might delete this
    }

    // Getter and Setter

    // Getter
    public String getCity() {
        return City;
    }

    /**
     * @param ID                        id of a customer, whose credit card should be upgraded to gold status
     * @param cList                     global list all possible customers
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to upgrade the card of this customer
     *                                  then upgrade his/her card to gold status
     */
    void upgradeRegToGold(int ID, ArrayList<Customer> cList) {
        // use super method of Employee
        super.upgradeRegToGold(ID, cList);
    }

    // helpers

    /**
     * @param c                         customer, which is assigned to an employees list
     * description                      adds a customer to the list of the employee,
     *                                  which calls the function
     */
    void addCustomer(Customer c) {
        // use super method of Employee
        super.addCustomer(c);
    }

    /**
     * @param e                         employee, whose customers list should be printed
     * description                      prints the list of assigned customers of an employee
     */
    void printCustomerList(Employee e) {
        // use super method of Employee
        super.printCustomerList(e);
    }

    /**
     * @param ID                        id of a customer, whose credit card should be downgraded from gold status
     *                                  to regular status
     * @param cList                     global list all possible customers
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to downgrade the card of this customer
     *                                  then downgrade his/her card to regular status
     */
    void downgradeGoldToReg(int ID, ArrayList<Customer> cList) {
        // find customer by id
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                if (c.ID == ID) {
                    // did find the customer
                    found = true;
                    // check if employee can actually downgrade
                    try {
                        // customer has platin card
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("You must not downgrade a platin card to regular card. Insufficient authorization.");
                        // customer has (already) regular card
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already a regular  card.");
                            // customer has gold card and could be downgraded
                        else {
                            c.setLimit(c, 2000);
                            System.out.println("Customer " + c.Surname + " " + c.Name + " has now a regular credit card with a new limit of 2000 CHF.");
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // did not find the customer
            if (!found) throw new IllegalArgumentException("This ID does not exist.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param ID                        id of a customer, whose credit card should be upgraded from gold status
     *                                  to platin status
     * @param cList                     global list all possible customers
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to upgrade the card of this customer
     *                                  then upgrade his/her card to platin status
     */
    void upgradeGoldToPlat(int ID, ArrayList<Customer> cList) {
        // find customer by id
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // did find the customer
                if (c.ID == ID) {
                    found = true;
                    // check if employee can actually upgrade
                    try {
                        // customer has regular card
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("You must not upgrade a regular card to plating card. Upgrade first to a gold card.");
                        // customer has (already) platin card
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("The customers credit card is already a platin  card.");
                            // customer has gold card and could be upgraded
                        else {
                            c.setLimit(c, 10000);
                            System.out.println("Customer " + c.Surname + " " + c.Name + " has now a platin credit card with a new limit of 10000 CHF.");
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (!found) throw new IllegalArgumentException("This ID does not exist.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
