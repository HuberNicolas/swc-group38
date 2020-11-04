public class Customer extends Person{
    private int Age;
    private int Money;
    private int IBAN;
    private CreditCard Card;

    public Customer(String surname, String name, int age, int id, int money){
        this.Surname = surname;
        this.Name = name;
        this.Age = age;
        this.ID = id;
        this.Money = money;
        this.IBAN = 12314+id; // generate in utils
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
