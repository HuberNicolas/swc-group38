import java.util.ArrayList;
/**
 * CLASS EMPLOYEE
 * base class for all entities of type EMPLOYEE
 * models an human entity of a MainChief
 */
public class MainChief extends Employee{

    // Constructor
    public MainChief(String name, String surname) {
        // use super constructor of Employee
        super(name, surname);
    }

    /**
     * @param ID                        id of a customer, whose credit card should be upgraded to gold status
     * @param cList                     list of customers assigned to the employee
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
     * @param cList                     list of customers assigned to the employee
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
     * @param ID                        id of a customer, whose credit card should be downgraded from platin status
     *                                  to gold status
     * @param cList                     list of customers assigned to the employee
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to downgrade the card of this customer
     *                                  then downgrade his/her card to gold status
     */
    void downgradePlatToGold(int ID, ArrayList<Customer> cList) {
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
                        // customer has (already) gold card
                        if (c.getLimit(c) == 5000) throw new IllegalArgumentException("You already got a gold Card");
                        // customer has just a regular card
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already just a regular  card.");
                        // customer has platin card card and could be upgraded
                        else {
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

    /**
     * @param ID                        id of a customer, whose credit card should be upgraded from gold status
     *                                  to platin status
     * @param cList                     list of customers assigned to the employee
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

    /**
     * @param ID                        id of a customer, whose credit card should be downgraded from any status
     *                                  to either gold status or regular status
     * @param state                     state that should downgraded to
     * @param cList                     list of customers assigned to the employee
     * description                      if a customer with the specific id exists and there is a valid option
     *                                  to downgrade the card of this customer
     *                                  then downgrade his/her card to gold or regular status, depending on "state"
     */
    void downgradeToState(int ID, ArrayList<Customer> cList, String state) { // downgrade to state=gold or state=regular
        // find customer by id
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    // did find the customer
                    found = true;
                    // check if employee can actually downgrade
                    try {
                        // downgrade to gold
                        if (state.equals("gold")) {
                            // has customer already gold card
                            if (c.getLimit(c) == 5000) throw new IllegalArgumentException("The customers credit card is already a gold  card.");
                            else {
                                // downgrade to gold
                                c.setLimit(c, 5000);
                                System.out.println("Customer " + c.Surname + " " + c.Name + " has now a gold credit card with a new limit of 5000 CHF.");
                            }
                        }
                        // downgrade to regular
                        else if (state.equals("regular")) {
                            // has customer already regular card
                            if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already a regular  card.");
                            else  {
                                // downgrade to regular
                                c.setLimit(c, 2000);
                                System.out.println("Customer " + c.Surname + " " + c.Name + " has now a regular credit card with a new limit of 2000 CHF.");
                            }
                        }
                        // invalid state
                        else {
                            throw new IllegalArgumentException("Unknown state name " + state + ". Please use either \"gold\" or \"regular\" ");
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
}
