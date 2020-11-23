public abstract class Vehicle {
    String name;
    int cost;
    CostBehavior costB;
    BagBehavior bagB;
    SpeedBehavior speedB;
    FuelBehavior fuelB;

    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setCostBehavior(CostBehavior costB){
        this.costB = costB;
    }
    public void setBagBehavior(BagBehavior bagB){
        this.bagB = bagB;
    }
    public void setSpeedBehavior(SpeedBehavior speedB){
        this.speedB = speedB;
    }
    public void setFuelBehavior(FuelBehavior fuelB){
        this.fuelB = fuelB;
    }


    public void printCostBehavior(){
        costB.printCostBehavior();
    }

    public void printBagBehavior(){
        bagB.printBagBehavior();
    }

    public void printSpeedBehavior(){
        speedB.printSpeedBehavior();
    }

    public void printFuelBehavior(){
        fuelB.printFuelBehavior();
    }

    public void printRide() {
        System.out.print(this.name + "; ");
        this.printBagBehavior();
        this.printSpeedBehavior();
        System.out.print(this.cost + " ");
        this.printCostBehavior();
    }
}

class MicroCar extends Vehicle{
    public MicroCar() {
        setName("Micro Car");
        setCost(12);
        setCostBehavior(new CHFhour());
        setBagBehavior(new smallBag());
        setSpeedBehavior(new normalSpeed());
        setFuelBehavior(new electric());
    }
}


class FamilyCar extends Vehicle{
    public FamilyCar() {
        setName("Family Car");
        setCost(15);
        setCostBehavior(new CHFhour());
        setBagBehavior(new twoSmallBagsTwoLargeBags());
        setSpeedBehavior(new normalSpeed());
        setFuelBehavior(new gasoline());
    }
}

class Supercar extends Vehicle{
    public Supercar() {
        setName("Supercar");
        setCost(30);
        setCostBehavior(new CHFhour());
        setBagBehavior(new oneSmallBagOneLargeBag());
        setSpeedBehavior(new fastSpeed());
        setFuelBehavior(new gasoline());
    }
}
class Bus extends Vehicle{
    public Bus() {
        setName("Bus");
        setCost(5);
        setCostBehavior(new CHF());
        setBagBehavior(new unlimited());
        setSpeedBehavior(new slowSpeed());
        setFuelBehavior(new diesel());
    }
}

