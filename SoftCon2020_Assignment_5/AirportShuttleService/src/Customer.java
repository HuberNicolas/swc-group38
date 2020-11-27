import java.util.Objects;

public class Customer {
    private String date;
    private Vehicle vehicle;

    public Customer(String date, Vehicle vehicle) {
        this.date = date;
        this.vehicle = vehicle;
    }

    public void ride(){
        try{
            this.vehicle.printRide();
    } catch (NullPointerException e) {
            System.out.print("Customer can't ride, there is no vehicle chosen");
        }
    }
}
