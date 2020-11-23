import java.math.BigDecimal;

public class ChocolateDecorator extends FoodDecorator {
    FoodItem FoodItem;
    public ChocolateDecorator(FoodItem CaketoDocorate){
        FoodItem = CaketoDocorate;
    }

    @Override public BigDecimal price() {
        return FoodItem.price().add(new BigDecimal("2.00")); }


}