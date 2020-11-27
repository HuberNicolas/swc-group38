import java.math.BigDecimal;
/**
 * is a tuna Decorator for a sandwich
 */

public class TunaDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public TunaDecorator(FoodItem SandwichToDoctorate){ FoodItem = SandwichToDoctorate; }

    /**
     *
     * @return the new price of the food item sandwich, inclusive the food decorator
     * tuna
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("3.00")); }
}