import java.math.BigDecimal;

public class Item {

    private BigDecimal price;
    private ItemType description;

    public Item(BigDecimal price, ItemType description) {
        this.price = price;
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemType getDescription() {
        return description;
    }
}
