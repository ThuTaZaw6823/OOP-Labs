public class Coffee extends Product {

    private String roastLevel;

    public Coffee(String name, double price, String roastLevel) {
        super(name, price);

        boolean validRoast = false;

        if (roastLevel != null) {
            String enteredRoast = roastLevel.trim();

            for (String level : getRoastLevels()) {
                if (level.equalsIgnoreCase(enteredRoast)) {
                    this.roastLevel = level;
                    validRoast = true;
                    break;
                }
            }
        }
        if (!validRoast) {
            throw new IllegalArgumentException("Choose Light, Medium, Medium-dark, or Dark.");
        }
    }

    public static String[] getRoastLevels() {
        String[] levels = {"Light", "Medium", "Medium-dark", "Dark"};
        return levels;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    @Override
    public String getType() {
        return "Coffee";
    }

    @Override
    public String getDetails() {
        return "Roast Level: " + roastLevel;
    }
}
