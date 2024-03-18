/**
 * Represents a slot within a machine that holds a specific type of product.
 * The slot has a capacity limit and can contain multiple units of the same product.
 */
public class MachineSlots {
    private int count = 0;
    private Product productType;

    /**
     * Adds a product to the slot if it matches the product type already in the slot and if the slot is not full.
     *
     * @param product The product to be added to the slot.
     * @return 0 if the product is successfully added, -1 if the product does not match the type or the slot is full.
     */
    public int addProduct(Product product) {
        if (count == 0) {
            productType = product;
            count++;
            return 0;
        } else if (productType.equals(product) && count < 10) {
            count++;
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Removes a product from the slot, if there are any products in it.
     *
     * @return 0 if a product is successfully removed, -1 if the slot is empty.
     */
    public int removeProduct() {
        if (count > 0) {
            count--;
            if (count == 0) {
                productType = null;
            }
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Checks if the slot is full.
     *
     * @return true if the slot is full, false otherwise.
     */
    public boolean isFull() {
        return count == 10;
    }

    /**
     * Checks if the slot is empty.
     *
     * @return true if the slot is empty, false otherwise.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Gets the product type that the slot holds.
     *
     * @return The product type in the slot.
     */
    public Product getProduct() {
        return productType;
    }

    /**
     * Gets the count of products in the slot.
     *
     * @return The number of products in the slot.
     */
    public int getCount() {
        return count;
    }
}
