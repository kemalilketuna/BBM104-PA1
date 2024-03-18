import java.io.*;

/**
 * Utility class for reading product information from a file and adding the products to a SlotManager.
 */
public class ProductReader {

    /**
     * Reads product data from a specified file and adds the products to a SlotManager.
     * Each line of the file is expected to contain product information separated by tabs,
     * with the product's nutrients separated by spaces.
     *
     * @param filename The name of the file containing product data.
     * @return A SlotManager instance populated with the products read from the file.
     * @throws RuntimeException If there is an error reading the file.
     */
    public static SlotManager addProductsFromFile(String filename) {
        try {
            SlotManager productPlanner = new SlotManager(24);

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.split("\t");
                String name = productInfo[0];
                int price = Integer.parseInt(productInfo[1]);
                String[] nutrients = productInfo[2].split(" ");
                float protein = Float.parseFloat(nutrients[0]);
                float carb = Float.parseFloat(nutrients[1]);
                float fat = Float.parseFloat(nutrients[2]);
                productPlanner.addProduct(new Product(name, price, protein, carb, fat));
            }
            reader.close();
            return productPlanner;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
    }
}
