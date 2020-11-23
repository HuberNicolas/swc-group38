public class Customer {
    private String date;
    private Vehicle vehicle;

    public Customer(String date, Vehicle vehicle) {
        this.date = date;
        this.vehicle = vehicle;
    }

    public void ride(){
        this.vehicle.printRide();
    }
}
