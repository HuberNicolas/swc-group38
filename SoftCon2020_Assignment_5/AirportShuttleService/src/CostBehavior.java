public interface CostBehavior {
    public void printCostBehavior();
}

class CHFhour implements CostBehavior{
    @Override
    public void printCostBehavior() {
        System.out.print("CHF/h" + "\n");
    }
}

class CHF implements CostBehavior{
    @Override
    public void printCostBehavior() {
        System.out.print("CHF" + "\n");
    }
}