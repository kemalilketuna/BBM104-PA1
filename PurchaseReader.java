import java.util.*;
import java.io.*;

public class PurchaseReader {
    // read purchase.txt file

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
            throw new RuntimeException("Error reading file: " + e);
        }
    }
    
}
