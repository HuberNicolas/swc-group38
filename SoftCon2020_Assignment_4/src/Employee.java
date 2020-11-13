import java.util.ArrayList;
/**
 * CLASS EMPLOYEE
 * base class for all entities of type EMPLOYEE
 * models an human entity of a employee
 */
public class Employee extends Person{
    public ArrayList<Customer> CustomerList;

    // Constructor
    public Employee(String name, String surname) {
        // regular employee
        this.Surname = surname;                     // eg. Fish
        this.Name = name;                           // eg. John
        this.ID = Utils.generateID();               // eg. 183
        this.CustomerList = setCustomerList();      // empty list, that stores assigned customers
    }

    // Getter and Setter

    // Setter
    ArrayList<Customer> setCustomerList() {
        return new ArrayList<Customer>();
    }

    /*
     * The following methods are the base methods.
     * Any type of employee can do this, as long
     * as we have correct parameters.
     */


    /**
     * @param ID                        id of a customer, whose credit card should be upgraded from regular status
     *                                  to gold status
     * @param cList                     global list all possible customers
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to upgrade the card of this customer
     *                                  then upgrade his/her card to gold status
     */
    void upgradeRegToGold(int ID, ArrayList<Customer> cList) {
        // find customer by id
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                if (c.ID == ID) {
                    // did find the customer
                    found = true;
                    // check if employee can actually upgrade
                    try {
                        // customer has platin card
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("You must not downgrade a platin card to gold card. Insufficient authorization.");
                        // customer has (already) gold card
                        if (c.getLimit(c) == 5000) throw new IllegalArgumentException("The customers credit card is already a gold card.");
                        // customer has regular card and could be upgraded
                        else { // added the else
                            c.setLimit(c, 5000);
                            System.out.println("Customer " + c.Surname + " " + c.Name + " has now a gold credit card with a new limit of 5000 CHF.");
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

    // helpers

    /**
     * @param c                         customer, which is assigned to an employees list
     * description                      adds a customer to the list of the employee,
     *                                  which calls the function
     */
    void addCustomer(Customer c) {
       CustomerList.add(c);
    }

    /**
     * @param e                         employee, whose customers list should be printed
     * description                      prints the list of assigned customers of an employee
     */
    void printCustomerList(Employee e) {
        System.out.println("Employee " + e.Surname + " "+ e.Name +" has the following customers assigned:");
        for (Customer c: e.CustomerList) {
            System.out.println("ID: " + c.ID + " : " + c.Surname + " " + c.Name);
        }
    }
}


