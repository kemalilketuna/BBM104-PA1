/**
 * Represents a product with nutritional and pricing information.
 * The product's calories are calculated based on its protein, carb, and fat content.
 */
public class Product {
    private String name;
    private int price;
    private float protein;
    private float carb;
    private float fat;
    private float calories;

    /**
     * Constructs a Product instance with specified nutritional and pricing details.
     *
     * @param name The name of the product.
     * @param price The price of the product in currency units.
     * @param protein The protein content in grams.
     * @param carb The carbohydrate content in grams.
     * @param fat The fat content in grams.
     */
    public Product(String name, int price, float protein, float carb, float fat) {
        this.name = name;
        this.price = price;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.calories = 4 * protein + 4 * carb + 9 * fat;
    }

    /**
     * Returns the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the protein content of the product.
     *
     * @return The protein content in grams.
     */
    public float getProtein() {
        return protein;
    }

    /**
     * Returns the carbohydrate content of the product.
     *
     * @return The carbohydrate content in grams.
     */
    public float getCarb() {
        return carb;
    }

    /**
     * Returns the fat content of the product.
     *
     * @return The fat content in grams.
     */
    public float getFat() {
        return fat;
    }

    /**
     * Returns the calculated calories of the product based on its macronutrient content.
     *
     * @return The total calories of the product.
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Returns the price of the product.
     *
     * @return The price in currency units.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Compares this product with the specified object for equality.
     * Two products are considered equal if they have the same name.
     *
     * @param obj The object to compare this product against.
     * @return true if the specified object is equal to this product; false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return name.equals(product.getName());
    }
}
