import java.math.BigDecimal;

public class HamDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public HamDecorator(FoodItem SandwhichToDocorate){
        FoodItem = SandwhichToDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("2.00")); }


}