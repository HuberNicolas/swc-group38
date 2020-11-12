import java.util.ArrayList;

public class MainChief extends Employee{

    public MainChief(String name, String surname) {
        super(name, surname);
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
    void downgradePlatToGold(int ID, ArrayList<Customer> cList) {
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    found = true;
                    try {
                        if (c.getLimit(c) == 5000) throw new IllegalArgumentException("You already got a gold Card");
                        if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already just a regular  card.");
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
                        c.setLimit(c, 10000);
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


    void downgradeToState(int ID, ArrayList<Customer> cList, String state) { // downgrade to state=gold or state=regular
        try {
            boolean found = false;
            // search
            for (Customer c: cList) {
                // found
                if (c.ID == ID) {
                    found = true;
                    try {
                        if (state.equals("gold")) {
                            if (c.getLimit(c) == 5000) throw new IllegalArgumentException("The customers credit card is already a gold  card.");
                            c.setLimit(c, 5000);
                            System.out.println("Customer " + c.Surname + " " + c.Name + " has now a gold credit card with a new limit of 5000 CHF.");
                        }
                        else if (state.equals("regular")) {
                            if (c.getLimit(c) == 2000) throw new IllegalArgumentException("The customers credit card is already a regular  card.");
                            c.setLimit(c, 2000);
                            System.out.println("Customer " + c.Surname + " " + c.Name + " has now a regular credit card with a new limit of 2000 CHF.");
                        }
                        else {
                            throw new IllegalArgumentException("Unknown state name " + state + ". Please use either \"gold\" or \"regular\" ");
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
