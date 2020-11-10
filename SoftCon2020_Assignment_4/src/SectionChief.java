import java.util.ArrayList;

public class SectionChief extends Employee{
    private String City;

    public SectionChief(String name, String surname, String city) {
        super(name, surname);
        this.City = city;
        //this.CustomerList = new ArrayList<Customer>();
        this.CustomerList = super.setCustomerList();
    }


    void upgradeRegToGold(int id, ArrayList<Customer> globalCustomerList) {
        super.upgradeRegToGold(id, globalCustomerList);
    }

    void addCustomer(Customer c) {
        super.addCustomer(c);
    }

    void printCustomerList(Employee e) {
        super.printCustomerList(e);
    }

    void downgradeGoldToReg(int ID, ArrayList<Customer> cList) {
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    found = true;
                    try {
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("You must not downgrade a platin card to regular card. Insufficient authorization.");
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already a regular  card.");
                        c.setLimit(c, 2000);
                        System.out.println("Customer " + c.Surname + " " + c.Name + " has now a regular credit card with a new limit of 2000 CHF.");
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

    void upgradeGoldToPlat(int ID, ArrayList<Customer> cList) {
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    found = true;
                    try {
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("You must not upgrade a regular card to plating card. Upgrade first to a gold card.");
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("The customers credit card is already a platin  card.");
                        c.setLimit(c, 2000);
                        System.out.println("Customer " + c.Surname + " " + c.Name + " has now a platin credit card with a new limit of 10000 CHF.");
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
