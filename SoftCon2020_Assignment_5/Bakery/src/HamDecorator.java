import java.math.BigDecimal;
/**
 * is a ham Decorator for a sandwich
 */
public class HamDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public HamDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    /**
     *
     * @return the new price of the food item sandwich, inclusive the food decorator
     * ham
     */
    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("2.00")); }
}