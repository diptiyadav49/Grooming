package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ProductWarranty {

    static class Product {
        private String id;
        private String name;
        private boolean warranty;
        private Category category;

        public Product(String id, String name, boolean warranty, Category category) {
            this.id = id;
            this.name = name;
            this.warranty = warranty;
            this.category = category;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public boolean hasWarranty() {
            return warranty;
        }

        public Category getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", warranty=" + warranty +
                    ", category=" + category +
                    '}';
        }
    }

    enum Category {
        Mobile,
        Laptop,
        TV,
        Refrigerator
    }

    public static void main(String[] args) {
        // create a list of products
        List<Product> products = Arrays.asList(
                new Product("P001", "iPhone 12", true, Category.Mobile),
                new Product("P002", "MacBook Pro", true, Category.Laptop),
                new Product("P003", "Samsung TV", true, Category.TV),
                new Product("P004", "LG Refrigerator", false, Category.Refrigerator),
                new Product("P005", "OnePlus 9", true, Category.Mobile),
                new Product("P006", "Dell XPS 15", false, Category.Laptop),
                new Product("P007", "Sony TV", false, Category.TV),
                new Product("P008", "Whirlpool Refrigerator", false, Category.Refrigerator),
                new Product("P009", "Google Pixel 5", true, Category.Mobile),
                new Product("P010", "HP Spectre x360", true, Category.Laptop)
        );

        // get the category to filter from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category to filter (Mobile/Laptop/TV/Refrigerator): ");
        String categoryStr = scanner.nextLine();
        Category category = Category.valueOf(categoryStr);

        // create predicates for filtering products
        Predicate<Product> hasWarranty = Product::hasWarranty;
        Predicate<Product> matchesCategory = product -> product.getCategory() == category;

        // filter products based on category and warranty
        List<Product> withWarranty = filter(products, matchesCategory.and(hasWarranty));
        List<Product> withoutWarranty = filter(products, matchesCategory.and(hasWarranty.negate()));

        // print the filtered lists
        System.out.println("Products with warranty:");
        printList(withWarranty);
        System.out.println("Products without warranty:");
        printList(withoutWarranty);
    }

    private static List<Product> filter(List<Product> products, Predicate<Product> predicate) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (predicate.test(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    private static void printList(List<Product> products) {
        products.forEach(System.out::println);
    }
}

