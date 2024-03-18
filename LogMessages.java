/**
 * Provides a collection of static methods to log various messages related to the operation of a vending machine.
 * This includes logs for machine states, product availability, and transaction outcomes.
 */
public class LogMessages {
    private static String machineIsFull = "INFO: The machine is full!";
    private static String noAvailableSpace = "INFO: There is no available place to put %s";
    private static String commandLog = "INPUT: %s";
    private static String insufficientMonet = "INFO: Insufficient money, try again with more money.";
    private static String numberCannotBeAccepted = "INFO: Number cannot be accepted. Please try again with another number.";
    private static String productNotAvailable = "INFO: Product not found, your money will be returned.";
    private static String slotIsEmpty = "INFO: This slot is empty, your money will be returned.";
    private static String productPurchased = "PURCHASE: You have bought one %s";
    private static String returningChance = "RETURN: Returning your change: %d TL";
    
    /**
     * Logs a message indicating that the machine is full.
     */
    public static void machineIsFull() {
        System.out.println(machineIsFull);
    }

    /**
     * Logs a message indicating that there is no available space for a specific product.
     *
     * @param productName The name of the product for which space is unavailable.
     */
    public static void noAvailableSpace(String productName) {
        System.out.println(String.format(noAvailableSpace, productName));
    }

    /**
     * Generates a log entry for a product, showing its name, calorie content, and count.
     *
     * @param product The product to log.
     * @param count The count of the product.
     * @return The formatted log entry string.
     */
    private static String productLog(Product product, int count){
        if (product == null){
            return "___(0, 0)___";
        }
        return String.format("%s(%d, %d)___", product.getName(), (int) Math.round(product.getCalories()), count);
    }

    /**
     * Logs the current state of the machine slots, displaying the products and their quantities.
     *
     * @param slots The array of MachineSlots to log.
     */
    public static void slotLog(MachineSlots[] slots){
        System.out.println("-----Gym Meal Machine-----");
        for (int i = 0; i < slots.length; i++){
            System.out.print(productLog(slots[i].getProduct(), slots[i].getCount()));
            if (i % 4 == 3){
                System.out.println();
            }
        }
        System.out.println("----------");
    }

    /**
     * Logs a command input by the user.
     *
     * @param command The command string to log.
     */
    public static void commandLog(String command){
        System.out.println(String.format(commandLog, command));
    }

    /**
     * Logs a message indicating insufficient money was inserted.
     */
    public static void insufficientMonet() {
        System.out.println(insufficientMonet);
    }

    /**
     * Logs a message indicating that a number cannot be accepted.
     */
    public static void numberCannotBeAccepted() {
        System.out.println(numberCannotBeAccepted);
    }

    /**
     * Logs a message indicating that a product is not available.
     */
    public static void productNotAvailable() {
        System.out.println(productNotAvailable);
    }

    /**
     * Logs a message indicating that a selected slot is empty.
     */
    public static void slotIsEmpty() {
        System.out.println(slotIsEmpty);
    }

    /**
     * Logs a message indicating a product has been purchased.
     *
     * @param productName The name of the purchased product.
     */
    public static void productPurchased(String productName) {
        System.out.println(String.format(productPurchased, productName));
    }

    /**
     * Logs a message indicating the change is being returned to the user.
     *
     * @param change The amount of change being returned.
     */
    public static void returningChance(int change) {
        System.out.println(String.format(returningChance, change));
    }
}
