import java.math.BigDecimal;
/**
 * is a strawberry Decorator for a cake
 */

public class StrawberriesDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public StrawberriesDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    /**
     *
     * @return the new price of the food item cake, inclusive the food decorator
     * strawberry
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.00")); }
}
