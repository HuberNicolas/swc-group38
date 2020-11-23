
class Main {
    public static void main(String[] args) {
        Customer Sandro = new Customer("12.03.2020", new MicroCar());
        Sandro.ride();
        Customer Marco = new Customer("12.04,2020", new Bus());
        Marco.ride();
        Customer Felix = new Customer("12.05,2020", new Supercar());
        Felix.ride();
        Customer George = new Customer("12.06,2020", new FamilyCar());
        George.ride();
    }
}