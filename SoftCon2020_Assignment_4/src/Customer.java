
public class Customer extends Person{
    private int Age;
    private int Money;
    private int IBAN;
    private CreditCard Card;
    private int Limit; // defines type
    //private String Type;

    public Customer(String surname, String name, int limit, int age, int money){
        this.Surname = surname;
        this.Name = name;
        this.ID = Utils.generateID();
        this.Limit = limit;
        this.Age = age;
        this.Money = money;
        this.IBAN = Utils.generateIBAN(); // generate in utils
        this.Card = new CreditCard(limit);
    }

    static CreditCard getCard(Customer c) {
        return c.Card;
    }

    static int getLimit(Customer c) {
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
        c.setMoney(c, c.getMoney(c)+value);
    }
    int withdraw(Customer c, int value) {
        try {
            if (value > c.Limit)throw new IllegalArgumentException("Your limit is not big enough. No Money was returned.");
            if (value > c.getMoney(c)) throw new IllegalArgumentException("There is not enough money on you bank account. No Money was returned.");
            else {
                c.setMoney(c, c.getMoney(c)-value);
                return value;
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Prolly change that just IBAN is needed -> Raphael fragen
    void bankTransfer(Customer sender, Customer receiver,  int value) {
        try {
            if (value > sender.getMoney(sender)) throw new IllegalArgumentException("There is not enough money on you bank account. No Money was sent.");
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
        try {
            //if (c.Card.)
            if (value > c.Limit)throw new IllegalArgumentException("Your current limit " + c.getLimit(c) + " is not big enough. This payment would overcharge your Creditcard.");
            else {
                System.out.println("Successfully payed " + value + " CHF by Card");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
