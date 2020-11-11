import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Customer extends Person{
    private int Age;
    private int Money;
    private int IBAN;
    private CreditCard Card;
    private int Limit; // defines type
    //private String Type;

    public Customer(String name, String surname, int limit, int age, int money){
        this.Name = name;
        this.Surname = surname;
        this.ID = Utils.generateID();

        this.Age = age;
        this.Money = money;
        this.IBAN = Utils.generateIBAN(); // generate in utils
        this.Card = new CreditCard(limit); // try catch
        this.Limit = limit;

    }

    static CreditCard getCard(Customer c) {
        return c.Card;
    }

    void setLimit(Customer c, int limit) {c.Limit = limit;}
    int getLimit(Customer c) {
        return c.Limit;
    } // getter & setter static???
    static int getAge(Customer c) {
        return c.Age;
    }
    static int getIBAN(Customer c) {
        return c.IBAN;
    }

    int getMoney(Customer c) {
        return c.Money;
    }
    void setMoney(Customer c, int m) {
        c.Money = m;
    }


    void deposit(Customer c, int value) {
        try {
            if(value < 0) throw new IllegalArgumentException("You cannot deposit less than 0 CHF. No Money was deposited.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        c.setMoney(c, c.getMoney(c)+value);
    }

    int withdraw(Customer c, int value) {
        try {
            if (value > c.Limit)throw new IllegalArgumentException("Your limit is not big enough. No Money was returned.");
            if (value > c.getMoney(c)) throw new IllegalArgumentException("There is not enough money on you bank account. No Money was returned.");
            else {
                c.setMoney(c, c.getMoney(c)-value);
                System.out.println("You successfully withdraw " + value + " CHF from your bank account.");
                return value;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //System.out.println("You did not withdraw any money CHF from your bank account.");
            return 0;
        }
    }

    // Prolly change that just IBAN is needed -> Raphael fragen
    void bankTransfer(Customer sender, Customer receiver,  int value) {
        try {
            if (value < 0) {
                // DO NOT DELETE THIS; WAS TO UNDERSTAND HOW FAIL WORKS!
                //String abc = "A";
                //System.out.println(abc.charAt(value));
                throw new IllegalArgumentException("You can not send a negative amount of money. No Money was transferred.");
            }
            if (value > sender.getMoney(sender)) throw new IllegalArgumentException("There is not enough money on you bank account. No Money was transferred.");
            else {
                sender.setMoney(sender, sender.getMoney(sender)-value);
                receiver.setMoney(receiver, receiver.getMoney(receiver)+value);
                System.out.println("Successfully transferred " + value + " CHF from " + sender.IBAN + " to " + receiver.IBAN);
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    void payWithCard(Customer c, int value) {
        // generating todays date
        Clock cl = Clock.systemUTC();
        LocalDate today= LocalDate.now(cl);
        try {
            if (c.getCard(c).getExpDate(c.getCard(c)).compareTo(today) < 0) throw new IllegalArgumentException("Your creditcard experienced at " + c.getCard(c).getExpDate(c.getCard(c)).format(DateTimeFormatter.ofPattern("dd-MM-yy")) + " No transaction was made.");
            if (value > c.Limit) throw new IllegalArgumentException("Your current limit " + c.getLimit(c) + " is not big enough. This payment would overcharge your creditcard. No transaction was made.");
            else {
                System.out.println("Successfully payed " + value + " CHF by Card");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
