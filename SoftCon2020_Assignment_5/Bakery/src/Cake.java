import java.math.BigDecimal;

/**
 * class cake is extending FoodItem and is a type of product you can buy
 */
public class Cake extends FoodItem{
    @Override
    public BigDecimal price() {
        return new BigDecimal("3.00");
    }
}
