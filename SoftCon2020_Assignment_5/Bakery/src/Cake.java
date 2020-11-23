import java.math.BigDecimal;

public class Cake extends FoodItem{
    @Override
    public BigDecimal price() {
        return new BigDecimal("3.00");
    }
}
