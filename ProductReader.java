import java.io.*;

public class ProductReader {
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
            throw new RuntimeException("Error reading file: " + e);
        }
    }
    
}
