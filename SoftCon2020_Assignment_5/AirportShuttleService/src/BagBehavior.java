/**
 * interface for the bag behaviour
 */
public interface BagBehavior {
    public void printBagBehavior();
}

// encapsulated bag behaviour
class smallBag implements BagBehavior{
    @Override
    public void printBagBehavior() {
        System.out.print("1 small bag; ");
    }
}

class twoSmallBagsTwoLargeBags implements BagBehavior{
    @Override
    public void printBagBehavior() {
        System.out.print("2 small and 2 large bags; ");
    }
}

class oneSmallBagOneLargeBag implements BagBehavior{
    @Override
    public void printBagBehavior() {
        System.out.print("1 small and 1 large bag; ");
    }
}

class unlimited implements BagBehavior{
    @Override
    public void printBagBehavior() {
        System.out.print("unlimited bags; ");
    }
}