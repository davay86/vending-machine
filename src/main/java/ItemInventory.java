import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemInventory {

    List<Item> items;

    private static ItemInventory instance = null;

    private ItemInventory(){
       items = new ArrayList<>();
       fillVendingMachine();
    }

    public static ItemInventory getInstance() {
        if(instance == null){
            instance = new ItemInventory();
        }
        return instance;
    }

    private void fillVendingMachine(){
        items.add(new Item(new BigDecimal(0.10),ItemType.CANDY));
        items.add(new Item(new BigDecimal(0.10),ItemType.CANDY));
        items.add(new Item(new BigDecimal(0.10),ItemType.CANDY));
        items.add(new Item(new BigDecimal(0.10),ItemType.CANDY));

        items.add(new Item(new BigDecimal(0.50),ItemType.SNACK));
        items.add(new Item(new BigDecimal(0.50),ItemType.SNACK));
        items.add(new Item(new BigDecimal(0.50),ItemType.SNACK));
        items.add(new Item(new BigDecimal(0.50),ItemType.SNACK));

        items.add(new Item(new BigDecimal(0.90),ItemType.NUTS));
        items.add(new Item(new BigDecimal(0.90),ItemType.NUTS));
        items.add(new Item(new BigDecimal(0.90),ItemType.NUTS));
        items.add(new Item(new BigDecimal(0.90),ItemType.NUTS));
    }

    public BigDecimal checkItemPrice(int itemNumber){
        Optional<Item> item = findItem(itemNumber);

        if(item.isPresent()){
            return item.get().getPrice();
        }else{
            return null;
        }
    }

    public void dispenseItem(int itemNumber){
        Optional<Item> item = findItem(itemNumber);

        if(item.isPresent()){
            items.remove(item.get());
            System.out.println(item.get().getDescription() + " dispensed");
        }else{
            System.out.println("Item not available");
        }
    }

    private Optional<Item> findItem(int itemNumber){
        switch(itemNumber){
            case 1:
                return items.stream().filter(e -> e.getDescription().equals(ItemType.CANDY)).findAny();
            case 2:
                return items.stream().filter(e -> e.getDescription().equals(ItemType.SNACK)).findAny();
            case 3:
                return items.stream().filter(e -> e.getDescription().equals(ItemType.NUTS)).findAny();
            default:
                System.out.println("Incorrect selection");
                return null;
        }
    }
}
