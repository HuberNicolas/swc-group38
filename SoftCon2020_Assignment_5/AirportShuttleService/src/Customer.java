import java.util.Objects;

public class Customer {
    private String date;
    private Vehicle vehicle;

    public Customer(String date, Vehicle vehicle) {
        this.date = Objects.requireNonNull(date, "Nullpoint Error!");
        this.vehicle = Objects.requireNonNull(vehicle, "Nullpoint Error!");
    }

    public void ride(){
                this.vehicle.printRide();
    }
}
