package ch04.ex06;

import java.util.Objects;

public class Item {
    private final String description;
    private final double price;

    public Item(String description, double price) {
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
