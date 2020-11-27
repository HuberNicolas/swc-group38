/**
 * abstract class vehicle that models a vehicle entity
 */

public abstract class Vehicle {
    String name;
    int cost;
    CostBehavior costB;
    BagBehavior bagB;
    SpeedBehavior speedB;
    FuelBehavior fuelB;

    // setters

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    // methods to set the behaviour dynamically using the
    // strategy pattern

    /**
     *
     * @param costB
     */
    public void setCostBehavior(CostBehavior costB){
        this.costB = costB;
    }

    /**
     *
     * @param bagB
     */
    public void setBagBehavior(BagBehavior bagB){
        this.bagB = bagB;
    }

    /**
     *
     * @param speedB
     */
    public void setSpeedBehavior(SpeedBehavior speedB){
        this.speedB = speedB;
    }

    /**
     *
     * @param fuelB
     */
    public void setFuelBehavior(FuelBehavior fuelB){
        this.fuelB = fuelB;
    }

    // printer

    /**
     *
     */
    public void printCostBehavior(){
        costB.printCostBehavior();
    }

    /**
     *
     */
    public void printBagBehavior(){
        bagB.printBagBehavior();
    }

    /**
     *
     */
    public void printSpeedBehavior(){
        speedB.printSpeedBehavior();
    }

    /**
     *
     */
    public void printFuelBehavior(){
        fuelB.printFuelBehavior();
    }

    /**
     *
     */
    public void printRide() {
        System.out.print(this.name + "; ");
        this.printBagBehavior();
        this.printSpeedBehavior();
        System.out.print(this.cost + " ");
        this.printCostBehavior();
    }
}


// different vehicle entities

// MicroCar entity
class MicroCar extends Vehicle{
    public MicroCar() {
        setName("Micro Car");
        setCost(12);
        // using s
        setCostBehavior(new CHFhour());
        setBagBehavior(new smallBag());
        setSpeedBehavior(new normalSpeed());
        setFuelBehavior(new electric());
    }
}

// FamilyCar entity
class FamilyCar extends Vehicle{
    public FamilyCar() {
        setName("Family Car");
        setCost(15);
        // set behaviour dynamically
        setCostBehavior(new CHFhour());
        setBagBehavior(new twoSmallBagsTwoLargeBags());
        setSpeedBehavior(new normalSpeed());
        setFuelBehavior(new gasoline());
    }
}

// Supercar entity
class Supercar extends Vehicle{
    public Supercar() {
        setName("Supercar");
        setCost(30);
        // set behaviour dynamically
        setCostBehavior(new CHFhour());
        setBagBehavior(new oneSmallBagOneLargeBag());
        setSpeedBehavior(new fastSpeed());
        setFuelBehavior(new gasoline());
    }
}

// Bus entity
class Bus extends Vehicle{
    public Bus() {
        setName("Bus");
        setCost(5);
        // set behaviour dynamically
        setCostBehavior(new CHF());
        setBagBehavior(new unlimited());
        setSpeedBehavior(new slowSpeed());
        setFuelBehavior(new diesel());
    }
}

