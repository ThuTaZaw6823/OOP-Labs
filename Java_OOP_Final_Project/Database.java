import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<ProductInterface> products = new ArrayList<>();

    public static void addProduct(ProductInterface product) {
        checkProduct(product);
        products.add(product);
    }

    public static int getProductCount() {
        return products.size();
    }

    public static ProductInterface getProduct(int index) {
        checkIndex(index);
        return products.get(index);
    }

    public static void updateProduct(int index, ProductInterface replacement) {
        checkIndex(index);
        checkProduct(replacement);
        products.set(index, replacement);
    }

    public static void deleteProduct(int index) {
        checkIndex(index);
        products.remove(index);
    }

    private static void checkProduct(ProductInterface product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty.");
        }
    }

    private static void checkIndex(int index) {
        if (index < 0 || index >= products.size()) {
            throw new IllegalArgumentException("Please select an existing product.");
        }
    }
}
