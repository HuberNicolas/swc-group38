import java.math.BigDecimal;

/**
 * is a Chocolate Decorator for a cake
 */

public class ChocolateDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public ChocolateDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    /**
     *
     * @return the new price of the food item cake, inclusive the food decorator
     * chocolate
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("2.00")); }
}