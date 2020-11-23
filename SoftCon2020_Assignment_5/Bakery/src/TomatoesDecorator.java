import java.math.BigDecimal;

public class TomatoesDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public TomatoesDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("1.50")); }


}