import java.util.ArrayList;

public class Employee extends Person{
    public ArrayList<Customer> CustomerList;

    public Employee(String name, String surname) {
        // regular Employee
        this.Surname = surname;
        this.Name = name;
        this.ID = Utils.generateID();
        this.CustomerList = setCustomerList();
    }

    ArrayList<Customer> setCustomerList() {
        return new ArrayList<Customer>();
    }

    void upgradeRegToGold(int ID, ArrayList<Customer> cList) {
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    found = true;
                    try {
                        if (c.getLimit(c) == 10000) throw new IllegalArgumentException("You must not downgrade a platin card to gold card. Insufficient authorization.");
                        if (c.getLimit(c) == 5000) throw new IllegalArgumentException("The customers credit card is already a gold card.");
                        c.setLimit(c, 5000);
                        System.out.println("Customer " + c.Surname + " " + c.Name + " has now a gold credit card with a new limit of 5000 CHF.");
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

    void addCustomer(Customer c) {
       CustomerList.add(c);
    }

    void printCustomerList(Employee e) {
        System.out.println("Employee " + e.Surname + " "+ e.Name +" has the following customers assigned:");
        for (Customer c: e.CustomerList) {
            System.out.println("ID: " + c.ID + " : " + c.Surname + " " + c.Name);
        }

    }


}


