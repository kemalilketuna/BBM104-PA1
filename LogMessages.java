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
    
    public static void machineIsFull() {
        System.out.println(machineIsFull);
    }

    public static void noAvailableSpace(String productName) {
        System.out.println(String.format(noAvailableSpace, productName));
    }

    private static String productLog(Product product, int count){
        if (product == null){
            return "___(0, 0)___";
        }
        // round the calories to the nearest integer
        return String.format("%s(%d, %d)___", product.getName(), (int) Math.round(product.getCalories()), count);
    }

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

    public static void commandLog(String command){
        System.out.println(String.format(commandLog, command));
    }

    public static void insufficientMonet() {
        System.out.println(insufficientMonet);
    }

    public static void numberCannotBeAccepted() {
        System.out.println(numberCannotBeAccepted);
    }

    public static void productNotAvailable() {
        System.out.println(productNotAvailable);
    }

    public static void slotIsEmpty() {
        System.out.println(slotIsEmpty);
    }

    public static void productPurchased(String productName) {
        System.out.println(String.format(productPurchased, productName));
    }

    public static void returningChance(int change) {
        System.out.println(String.format(returningChance, change));
    }
}
