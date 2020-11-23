import java.math.BigDecimal;

public abstract class FoodDecorator extends FoodItem {
    @Override
    public abstract BigDecimal price();
}
