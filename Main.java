import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        PrintStream originalOut = System.out; // Store the original System.out to restore it later

        // TODO: Change this later
        // PrintStream fileOut = new PrintStream(new File(args[2]));
        // System.setOut(fileOut);
        
        ProductManager productManager = ProductReader.addProductsFromFile(args[0]);
        productManager.logSlots();
        PurchaseReader.readProductFile(args[1]);

        System.out.close();
        System.setOut(originalOut); // Restore the original System.out
    }
}
