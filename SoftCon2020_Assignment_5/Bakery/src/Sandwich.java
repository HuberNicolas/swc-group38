import java.math.BigDecimal;

/**
 * a type of FoodItem, product which you can buy
 */

public class Sandwich extends FoodItem {

    @Override
    public BigDecimal price() {
        //How much does a sandwich costs???
        return new BigDecimal("3.00");
    }
}
