import java.math.BigDecimal;
/**
 * is a Decorator for a cake
 */

public class StrawberriesDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public StrawberriesDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.00")); }


}
