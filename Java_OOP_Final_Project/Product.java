public abstract class Product implements ProductInterface {

    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException("Price must be a finite number greater than 0.");
        }

        this.name = name.trim();
        this.price = price;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String priceText = String.format("%.2f", getPrice());
        String description = getType() + " | Name: " + getName();
        description += " | Price: " + priceText;
        description += " | " + getDetails();
        return description;
    }
}

