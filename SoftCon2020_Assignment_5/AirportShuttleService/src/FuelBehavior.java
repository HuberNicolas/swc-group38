public interface FuelBehavior {
    public void printFuelBehavior();
}

class gasoline implements FuelBehavior {
    @Override
    public void printFuelBehavior() {
        System.out.print("gasoline");
    }
}

class diesel implements FuelBehavior{
    @Override
    public void printFuelBehavior() {
        System.out.print("diesel");
    }
}

class electric implements FuelBehavior{
    @Override
    public void printFuelBehavior() {
        System.out.print("electric");
    }
}