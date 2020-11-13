import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * CLASS CUSTOMER
 * base class for all entities of type CUSTOMER
 * models an human entity of a Customer
 */
public class Customer extends Person {
    private int Age;            // eg. 25
    private int Money;          // eg. 10000
    private int IBAN;           // eg. 171839
    private CreditCard Card;    // serial, security Code, exp date, type
    private int Limit;          // (2000 || 5000 || 10000)

    // Constructor
    public Customer(String name, String surname, int limit, int age, int money) {
        // Sanity checks
        try {
            if (age <= 0) {
                this.Age = 18;
                throw new IllegalArgumentException("An age <= 0 is not valid. Set age to default value of 18.");
            }
            if (age > 0) this.Age = age;
            if (money < 0) {
                this.Money = 0;
                throw new IllegalArgumentException("Your bank account must contain at least 0 CHF. Set default value of saving to 0.");
            }
            if (money >= 0) this.Money = money;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.Name = name;                           // eg. Ragoletti
        this.Surname = surname;                     // eg. Luciano
        this.ID = Utils.generateID();               // eg. 123
        //this.Age = age;                             // eg. 63
        //this.Money = money;                         // eg. 1000000000
        this.IBAN = Utils.generateIBAN();           // eg. 171839

        // check limit
        ArrayList<Integer> validLimit = new ArrayList<Integer>();
        validLimit.add(2000);   // regular customer
        validLimit.add(5000);   // golden customer
        validLimit.add(10000);  // platinum customer
        if (!validLimit.contains(limit)) {
            // entered limit is not valid. automatically set to a default limit = 2000
            System.out.println("Invalid limit entered! Set to default limit of 2000 CHF.");
            this.Card = new CreditCard(2000);
            this.Limit = 2000;      // eg. 2000
        } else {
            // entered limit is valid (either 2000, 5000 or 10000)
            this.Card = new CreditCard(limit);
            this.Limit = limit;     // eg. 5000
        }
    }

    // Getter and Setter

    // Getter
    static CreditCard getCard(Customer c) { return c.Card; }

    // Getter
    int getLimit(Customer c) { return c.Limit; }

    // Getter
    static int getAge(Customer c) { return c.Age; }

    // Getter
    int getIBAN(Customer c) { return c.IBAN; }

    // Getter
    int getMoney(Customer c) { return c.Money; }

    // Setter
    void setLimit(Customer c, int limit) { c.Limit = limit; }

    // Setter
    void setMoney(Customer c, int m) { c.Money = m; }

    // Setter
    void setIBAN(Customer c, int i) { c.IBAN = i; }

    /*
     * The following methods are the base methods.
     * Any type of customer can do this, as long
     * as we have correct parameters.
     */

    /**
     * @param c                         customer that wants to deposit an amount of money
     * @param value                     amount of money that should be deposited
     * description                      depositing money simply adds the sum of money deposited to the customer's
     *                                  savings
     */
    void deposit(Customer c, int value) {
        // is value >= 0
        try {
            if (value < 0)
                throw new IllegalArgumentException("You cannot deposit less than 0 CHF. No Money was deposited.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // add value to current savings
        c.setMoney(c, c.getMoney(c) + value);
        System.out.println("You successfully deposited " + value + " CHF to your bank account.");
    }

    /**
     * @param c                         customer that wants to withdraw an amount of money
     * @param value                     amount of money that should be withdrawn
     * @return                          amount of withdrawn money from customers bank account
     * description                      if entered a correct value (value >= 0 && value < customers saving)
     *                                  then return the amount of value from the bank account
     */
    int withdraw(Customer c, int value) {
        // is value >= 0 && is there enough money on customes bank account?
        try {
            if (value < 0)
                throw new IllegalArgumentException("You cannot withdraw less than 0 CHF. No Money was withdrawn.");
            if (value > c.getMoney(c))
                throw new IllegalArgumentException("There is not enough money on you bank account. No Money was withdrawn.");
            else {
                // withdraw money from current savings
                c.setMoney(c, c.getMoney(c) - value);
                System.out.println("You successfully withdraw " + value + " CHF from your bank account.");
                // return withdrawn value
                return value;
            }
        } catch (IllegalArgumentException e) {
            // return no money means return 0
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     *
     * @param sender                    customer that is sending money
     * @param IBAN                      IBAN of the customer who is receiving money
     * @param value                     amount of money that should be sent
     * @param cList                     list of all customers
     * description                      if entered a correct value (value >= 0 && value < customers saving)
     *                                  then return the amount of value from the bank account
     */
    void bankTransfer(Customer sender, int IBAN, int value, ArrayList<Customer> cList) {
        try {
            boolean found = false;
            // search
            for (Customer c : cList) {
                System.out.println(c.Name+""+c.IBAN);
                if (c.getIBAN(c) == IBAN) {
                    // did find the customer
                    found = true;
                    try {
                        if (value < 0) {
                            // DO NOT DELETE THIS; WAS TO UNDERSTAND HOW fail() WORKS!
                            //String abc = "A";
                            //System.out.println(abc.charAt(value));
                            throw new IllegalArgumentException("You can not send a negative amount of money. No Money was transferred.");
                        }
                        if (value > sender.getMoney(sender))
                            throw new IllegalArgumentException("There is not enough money on you bank account. No Money was transferred.");
                        else {
                            sender.setMoney(sender, sender.getMoney(sender) - value);
                            c.setMoney(c, c.getMoney(c) + value);
                            System.out.println("Successfully transferred " + value + " CHF from " + sender.IBAN + " to " + c.IBAN);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // did not find the customer
            if (!found) throw new IllegalArgumentException("This IBAN does not exist.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * @param c                         customer that wants to withdraw an amount of money
     * @param value                     amount of money that should be paid by card
     * description                      if entered a correct value (value >= 0 && value < customers limit)
     *                                  and if customers card is not expired
     *                                  then make a transaction by card
     */
    void payWithCard(Customer c, int value) {
        // generating today's date
        Clock cl = Clock.systemUTC();
        LocalDate today = LocalDate.now(cl);
        // sanity check
        try {
            if (value < 0) // invalid value
                throw new IllegalArgumentException("You cannot pay less than 0 CHF. No transaction was made.");
            if (c.getCard(c).getExpDate(c.getCard(c)).compareTo(today) < 0) // invalid date
                throw new IllegalArgumentException("Your credit card experienced at " + c.getCard(c).getExpDate(c.getCard(c)).format(DateTimeFormatter.ofPattern("dd-MM-yy")) + " No transaction was made.");
            if (value > c.Limit) // invalid limit
                throw new IllegalArgumentException("Your current limit " + c.getLimit(c) + " is not big enough. This payment would overcharge your credit card. No transaction was made.");
            else {
                // valid card
                System.out.println("Successfully payed " + value + " CHF by card");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}