public class MachineSlots {
    private int count = 0;
    private Product productType;

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

    public int removeProduct() {
        if (count > 0) {
            count--;
            return 0;
        }else if (count == 0) {
            productType = null;
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isFull() {
        return count == 10;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Product getProduct() {
        return productType;
    }

    public int getCount() {
        return count;
    }
}
