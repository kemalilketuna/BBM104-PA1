import java.util.*;

public class PurchasePlanner {
    private MachineSlots[] machineSlots;

    public PurchasePlanner(MachineSlots[] machineSlots) {
        this.machineSlots = machineSlots;
    }

    private void purchaseProductBySlot(int index, int totalMoney){
        if (index < 0 || index >= machineSlots.length){
            LogMessages.numberCannotBeAccepted();
            LogMessages.returningChance(totalMoney);
            return;
        }
        if (machineSlots[index].isEmpty()){
            LogMessages.slotIsEmpty();
            LogMessages.returningChance(totalMoney);
            return;
        }
        Product product = machineSlots[index].getProduct();
        if (product.getPrice() > totalMoney){
            LogMessages.insufficientMonet();
            LogMessages.returningChance(totalMoney);
            return;
        }else{
            machineSlots[index].removeProduct();
            LogMessages.productPurchased(product.getName());
            LogMessages.returningChance(totalMoney - product.getPrice());
        }        
    }

    private void purchaseProductByValue(String searchType, int searchValue, int totalMoney){
        for (int i = 0; i < machineSlots.length; i++){
            if (machineSlots[i].isEmpty()){
                continue;
            }
            Product product = machineSlots[i].getProduct();

            float amount = 0.0f;
            switch (searchType) {
                case "CARB":
                    amount = product.getCarb();
                    break;
                
                case "CALORIE":
                    amount = product.getCalories();
                    break;
                
                case "PROTEIN":
                    amount = product.getProtein();
                    break;

                case "FAT":
                    amount = product.getFat();
                    break;
            }

            if (Math.abs(amount - searchValue) <= 5){
                if (product.getPrice() > totalMoney){
                    LogMessages.insufficientMonet();
                    LogMessages.returningChance(totalMoney);
                    return;
                }else{
                    machineSlots[i].removeProduct();
                    LogMessages.productPurchased(product.getName());
                    LogMessages.returningChance(totalMoney - product.getPrice());
                    return;
                }
            }
        }
        LogMessages.productNotAvailable();
        LogMessages.returningChance(totalMoney);
    }

    public void executeCommand(String command){
        LogMessages.commandLog(command);
        String[] parts = command.split("\t");
        String searchType = parts[2];
        int searchValue = Integer.parseInt(parts[3]);
        int[] moneys = Arrays.stream(parts[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalMoney = 0;
        for (int money : moneys){
            totalMoney += money;
        }
        if (searchType.equals("NUMBER")){
            purchaseProductBySlot(searchValue, totalMoney);
        }else{
            purchaseProductByValue(searchType, searchValue, totalMoney);
        }
    }
}