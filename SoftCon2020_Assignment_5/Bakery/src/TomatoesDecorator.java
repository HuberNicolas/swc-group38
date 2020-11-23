import java.math.BigDecimal;
/**
 * is a Decorator for a sandwich
 */

public class TomatoesDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public TomatoesDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.50")); }


}