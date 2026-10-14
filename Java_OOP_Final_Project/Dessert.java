public class Dessert extends Product {
    private String flavor;

    public Dessert(String name, double price, String flavor) {
        super(name, price);
        if (flavor == null || flavor.trim().isEmpty()) {
            throw new IllegalArgumentException("Flavor cannot be empty.");
        }
        this.flavor = flavor.trim();
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String getType() {
        return "Dessert";
    }

    @Override
    public String getDetails() {
        return "Flavor: " + flavor;
    }
}

