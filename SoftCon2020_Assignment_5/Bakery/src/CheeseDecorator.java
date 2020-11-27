import java.math.BigDecimal;

/**
 * is a Cheese Decorator for a sandwich
 */

public class CheeseDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public CheeseDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    /**
     *
     * @return the new price of the food item sandwich, inclusive the food decorator
     * cheese
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.00")); }
}