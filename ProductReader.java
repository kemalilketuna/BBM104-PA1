import java.util.*;
import java.io.*;

public class ProductReader {
    // read product.txt file

    public static void readProductFile(String filename) {
        // read the file
        // return the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }
    
}
