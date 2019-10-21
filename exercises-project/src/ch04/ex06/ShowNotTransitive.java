package ch04.ex06;

public class ShowNotTransitive {
    public static void main(String[] args) {
        DiscountedItem x = new DiscountedItem("item", 1.0, 0.5);
        Item y = new Item("item", 1.0);
        DiscountedItem z = new DiscountedItem("item", 1.0, 0.25);

        System.out.printf(
                "x == y ? %s\ny == z ? %s\nx == z ? %s",
                x.equals(y),
                y.equals(z),
                x.equals(z)
        );
    }
}
