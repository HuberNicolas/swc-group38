import java.math.BigDecimal;
/**
 * is a Decorator for a cake
 */
public class CreamDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public CreamDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.50")); }


}