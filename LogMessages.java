public class LogMessages {
    private static String machineIsFull = "INFO: The machine is full!";
    private static String noAvailableSpace = "INFO: There is no available place to put %s";

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
}
