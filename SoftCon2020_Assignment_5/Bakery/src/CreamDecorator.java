import java.math.BigDecimal;
/**
 * is a cream Decorator for a cake
 */
public class CreamDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public CreamDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    /**
     *
     * @return the new price of the food item cake, inclusive the food decorator
     * cream
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.50")); }
}