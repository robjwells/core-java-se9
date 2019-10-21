package ch04.ex06;

import java.util.Objects;

public class DiscountedItem extends Item {
    private final double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        // Check if `o` is a DiscountedItem
        if (o.getClass() == this.getClass()) {
            DiscountedItem that = (DiscountedItem) o;
            return (Double.compare(that.discount, discount) == 0) && super.equals(that);
        } else {
            return super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
