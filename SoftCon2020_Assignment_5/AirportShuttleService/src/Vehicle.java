/**
 * abstract class vehicle that models a vehicle entity
 */

public abstract class Vehicle {
    String name; // e.g.
    int cost; // e.g.
    CostBehavior costB; // e.g.
    BagBehavior bagB; // e.g.
    SpeedBehavior speedB; // e.g.
    FuelBehavior fuelB; // e.g.

    // setters

    /**
     *
     * @param name name of the vehicle
     * description: setter method for the name attribute of a vehicle
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param cost cost of the vehicle
     * description: setter method for the cost attribute of a vehicle
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    // methods to set the behaviour dynamically using the
    // strategy pattern

    /**
     *
     * @param costB cost behaviour of the vehicle
     * description: setter method for the cost behaviour of a vehicle
     */
    public void setCostBehavior(CostBehavior costB){
        this.costB = costB;
    }

    /**
     *
     * @param bagB bag behaviour of the vehicle
     * description: setter method for the bag behaviour of a vehicle
     */
    public void setBagBehavior(BagBehavior bagB){
        this.bagB = bagB;
    }

    /**
     *
     * @param speedB cost behaviour of the vehicle
     * description: setter method for the speed behaviour of a vehicle
     */
    public void setSpeedBehavior(SpeedBehavior speedB){
        this.speedB = speedB;
    }

    /**
     *
     * @param fuelB cost behaviour of the vehicle
     * description: setter method for the fuel behaviour of a vehicle
     */
    public void setFuelBehavior(FuelBehavior fuelB){
        this.fuelB = fuelB;
    }

    // helper methods: printer

    /**
     * description: prints the cost behaviour of a vehicle
     */
    public void printCostBehavior(){
        costB.printCostBehavior();
    }

    /**
     * description: prints the bag behaviour of a vehicle
     */
    public void printBagBehavior(){
        bagB.printBagBehavior();
    }

    /**
     * description: prints the speed behaviour of a vehicle
     */
    public void printSpeedBehavior(){
        speedB.printSpeedBehavior();
    }

    /**
     * description: prints the fuel behaviour of a vehicle
     */
    public void printFuelBehavior(){
        fuelB.printFuelBehavior();
    }

    /**
     * description: prints the specific ride function for a
     *              vehicle entity, depending on the
     *              dynamically set behaviour
     *              for instance:
     *              "Micro car; 1 bag; normal speed; 12 CHF/h"
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

