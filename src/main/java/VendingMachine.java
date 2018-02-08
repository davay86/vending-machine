import java.math.BigDecimal;

public class VendingMachine {

    private static CashHandler cashHandler = CashHandler.getInstance();
    private static ItemInventory itemInventory = ItemInventory.getInstance();

    public static void main(String args[]) {
        cashHandler.acceptCash(ValidCash.FIFTY_PENCE);
        cashHandler.acceptCash(ValidCash.ONE_POUND);

        cashHandler.refundCash();

        cashHandler.acceptCash(ValidCash.FIFTY_PENCE);
        cashHandler.acceptCash(ValidCash.ONE_POUND);

        orderItem(1);

        cashHandler.acceptCash(ValidCash.TWENTY_PENCE);
        orderItem(2);
        cashHandler.acceptCash(ValidCash.TWENTY_PENCE);
        cashHandler.acceptCash(ValidCash.TWENTY_PENCE);

        orderItem(2);
    }

    public static void orderItem(int itemNumber){
        BigDecimal itemPrice = itemInventory.checkItemPrice(itemNumber);
        if(itemPrice != null){
            if(cashHandler.checkUserHasFunds(itemPrice)){
                itemInventory.dispenseItem(itemNumber);
                cashHandler.dispenseChange(itemPrice);
            }else{
                System.out.println("More funds needed");
            }
        }else{
            System.out.println("Item not available");
        }
    }
}
