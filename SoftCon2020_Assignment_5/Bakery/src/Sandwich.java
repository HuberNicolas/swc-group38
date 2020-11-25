import java.math.BigDecimal;

/**
 * a type of FoodItem, product which you can buy
 */

public class Sandwich extends FoodItem {

    @Override
    public BigDecimal price() {
        return new BigDecimal("2.00");
    }
}
