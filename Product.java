public class Product {
    // protein, carb. fat, calories
    private String name;
    private int price;
    private float protein;
    private float carb;
    private float fat;
    private float calories;

    public Product(String name, int price, float protein, float carb, float fat) {
        this.name = name;
        this.price = price;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.calories = 4*protein + 4*carb + 9*fat;
    }

    //getters
    public String getName() {
        return name;
    }

    public float getProtein() {
        return protein;
    }

    public float getCarb() {
        return carb;
    }

    public float getFat() {
        return fat;
    }

    public float getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    // equals method
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return name.equals(product.getName());
    }
}
