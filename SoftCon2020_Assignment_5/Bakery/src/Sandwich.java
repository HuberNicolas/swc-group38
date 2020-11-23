import java.math.BigDecimal;

public class Sandwich extends FoodItem {

    @Override
    public BigDecimal price() {
        //How much does a sandwich costs???
        return new BigDecimal("3.00");
    }
}
