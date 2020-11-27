import java.math.BigDecimal;
/**
 * is a tomato Decorator for a sandwich
 */

public class TomatoesDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public TomatoesDecorator(FoodItem SandwichToDoctorate){
        FoodItem = SandwichToDoctorate;
    }

    /**
     *
     * @return the new price of the food item sandwich, inclusive the food decorator
     * tomato
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.50")); }
}