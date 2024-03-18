/**
 * Manages the slots in a vending machine, allowing for products to be added and tracked within slots.
 */
public class SlotManager {
    private int slotCount;
    private MachineSlots[] machineSlots;
    private int emptySlotCount;
    private boolean isAllSlotsFull = false;
    private boolean isSlotManagerActive = true;

    /**
     * Constructs a SlotManager with a specified number of slots.
     *
     * @param slotCount The number of slots in the vending machine.
     */
    public SlotManager(int slotCount){
        this.slotCount = slotCount;
        this.emptySlotCount = slotCount;

        machineSlots = new MachineSlots[slotCount];
        for(int i = 0; i < slotCount; i++){
            machineSlots[i] = new MachineSlots();
        }
    }

    /**
     * Finds an available slot for a given product. Prefers non-empty, non-full slots with the same product,
     * otherwise an empty slot.
     *
     * @param product The product to find a slot for.
     * @return The index of the available slot, or -1 if no slot is available.
     */
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

    /**
     * Adds a product to an available slot. If all slots are full, logs a message and deactivates the slot manager if vending machine is full.
     *
     * @param product The product to add to the machine.
     */
    public void addProduct(Product product){
        if (!isSlotManagerActive){
            return;
        }

        int slotIndex = avaiableSlot(product);
        if (slotIndex != -1){
            MachineSlots slot = machineSlots[slotIndex];
            if(slot.isEmpty())
                emptySlotCount--;
            slot.addProduct(product);
        }else{
            LogMessages.noAvailableSpace(product.getName());
        }

        if (isAllSlotsFull){
            LogMessages.machineIsFull();
            isSlotManagerActive = false;
        }

        checkAllSlotsFull();
    }

    /**
     * Checks if all slots are full and updates the corresponding flags.
     */
    private void checkAllSlotsFull(){
        for(int i = 0; i < slotCount; i++){
            if(!machineSlots[i].isFull()){
                isAllSlotsFull = false;
                return;
            }
        }
        isAllSlotsFull = true;
    }

    /**
     * Determines if the machine is empty (all slots are empty).
     *
     * @return True if all slots are empty, false otherwise.
     */
    public boolean isMachineEmpty(){
        return emptySlotCount == slotCount;
    }

    /**
     * Returns the total number of slots in the machine.
     *
     * @return The number of slots.
     */
    public int getSlotCount(){
        return slotCount;
    }

    /**
     * Logs the current status of all slots in the machine.
     */
    public void logSlots(){
        LogMessages.slotLog(machineSlots);
    }

    /**
     * Returns the array of MachineSlots managed by this SlotManager.
     *
     * @return An array of MachineSlots.
     */
    public MachineSlots[] getMachineSlots(){
        return machineSlots;
    }
}
