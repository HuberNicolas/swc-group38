import java.math.BigDecimal;

/**
 * abstract class which extends FoodItem, defines the way a FoodDecorator has to be
 */
public abstract class FoodDecorator extends FoodItem {
    @Override
    public abstract BigDecimal price();
}
