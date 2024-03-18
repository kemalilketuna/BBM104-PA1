import java.util.*;
import java.io.*;

public class SlotManager {
    private int slotCount;
    private MachineSlots[] machineSlots;
    private int emptySlotCount;

    public SlotManager(int slotCount){
        this.slotCount = slotCount;
        this.emptySlotCount = slotCount;

        machineSlots = new MachineSlots[slotCount];
        for(int i = 0; i < slotCount; i++){
            machineSlots[i] = new MachineSlots();
        }
    }

    private int avaiableSlot(Product product){
        // find the first available slot same as the product if there is any use the first empty slot
        for(int i = 0; i < slotCount; i++){
            if(!machineSlots[i].isEmpty() && !machineSlots[i].isFull() && machineSlots[i].getProduct().equals(product)){
                return i;
            }
        }
        for(int i = 0; i < slotCount; i++){
            if(machineSlots[i].isEmpty()){
                return i;
            }
        }
        return -1;
    }

    public void addProduct(Product product){
        int slotIndex = avaiableSlot(product);
        if (slotIndex != -1){
            MachineSlots slot = machineSlots[slotIndex];
            if(slot.isEmpty())
                emptySlotCount--;
            slot.addProduct(product);
        }else{
            LogMessages.noAvailableSpace(product.getName());
        }
    }

    public boolean isMachineFull(){
        return emptySlotCount == 0;
    }

    public boolean isMachineEmpty(){
        return emptySlotCount == slotCount;
    }

    public int getSlothCount(){
        return slotCount;
    }

    public void logIsFull(){
        if (isMachineFull()){
            LogMessages.machineIsFull();
        }
    }

    public void logSlots(){
        LogMessages.slotLog(machineSlots);
    }
}
