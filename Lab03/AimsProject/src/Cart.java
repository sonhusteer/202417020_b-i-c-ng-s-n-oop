


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Đếm số lượng đĩa hiện có

    // Thêm đĩa
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Gợi ý: Hàm Xóa đĩa (Bạn tự code logic tìm và xóa nhé)
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i] == disc) {
            // Dịch chuyển các phần tử phía sau lên 1 ô
            for (int j = i; j < qtyOrdered - 1; j++) {
                itemsOrdered[j] = itemsOrdered[j + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--; // Cực kỳ quan trọng: phải giảm số lượng đĩa!
            System.out.println("The disc has been removed");
            return;
        }
    }
    System.out.println("The disc is not in the cart");
    }

    // Tính tổng tiền
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}

