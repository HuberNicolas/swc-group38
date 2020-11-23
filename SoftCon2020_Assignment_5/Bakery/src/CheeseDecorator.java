import java.math.BigDecimal;

public class CheeseDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public CheeseDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.00")); }


}