package ch02.ex15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Fully implement the Invoice class in Section 2.6.1, “Static Nested Classes” (page 85).
 * Provide a method that prints the invoice and a demo program that constructs
 * and prints a sample invoice.
 */
public class Invoice {
    private ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        Item coreJava = new Item("Core Java", 1, 25.50);
        Item fpInJava = new Item("FP in Java", 1, 30.12);
        Item code = new Item("Code", 12, 15.75);
        Invoice invoice = new Invoice();
        invoice.addItem(coreJava);
        invoice.addItem(fpInJava);
        invoice.addItem(code);
        System.out.println(invoice);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // This is pretty rough formatting-wise but it works.
    @Override
    public String toString() {
        String itemsReport = items.stream()
                .sorted(Comparator.comparing(Item::getDescription))
                .map(item -> String.format(
                        "%s\t\t%s\t%6.2f",
                        item.description,
                        item.quantity,
                        item.price())
                )
                .collect(Collectors.joining("\n"));
        return itemsReport + String.format(
                "\n\nTotal:\t\t\t%10.2f",
                items.stream().mapToDouble(Item::price).sum()
        );
    }

    public static class Item {
        private final String description;
        private final int quantity;
        private final double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getDescription() {
            return description;
        }

        public int getQuantity() {
            return quantity;
        }

        double price() {
            return quantity * unitPrice;
        }
    }
}
