import java.math.BigDecimal;

public class TunaDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public TunaDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("3.00")); }


}