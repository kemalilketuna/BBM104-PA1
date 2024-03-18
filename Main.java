import java.io.*;

/**
 * Main class to facilitate the operation of a vending machine system.
 * This class reads product and purchase information from files, processes purchases,
 * and logs the results to a specified output file.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream originalOut = System.out; // Store the original System.out to restore it later

        PrintStream fileOut = new PrintStream(new File(args[2]));
        System.setOut(fileOut);

        SlotManager slotManager = ProductReader.addProductsFromFile(args[0]);
        slotManager.logSlots();

        PurchasePlanner purchasePlanner = new PurchasePlanner(slotManager.getMachineSlots());

        PurchaseReader purchaseReader = new PurchaseReader(args[1]);
        for (String commands : purchaseReader) {
            purchasePlanner.executeCommand(commands);
        }

        slotManager.logSlots();
        System.out.close();
        System.setOut(originalOut); // Restore the original System.out
    }
}
