
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
    }
    void withdraw(Customer c, int value) {

    }

    void bankTransfer(Customer payer, Customer receiver,  int value) {

    }
}
