import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;
    private static InventoryManagementSystem instance;

    private InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public static InventoryManagementSystem getInstance() {
        if (instance == null) {
            instance = new InventoryManagementSystem();
        }
        return instance;
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        System.out.println("Item added to inventory: " + item);
    }

    public void searchItem(String item) {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(item)) {
                System.out.println("Item found");
                System.out.println("Item name: " + entry.getKey());
                System.out.println("Quantity: " + entry.getValue());
                return;
            }
        }
    }

    public void decreaseQuantity(String item, int quantityToSubtract) {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(item)) {
                int currentQuantity = entry.getValue();
                int newQuantity = currentQuantity - quantityToSubtract;
                if (newQuantity >= 0) {
                    entry.setValue(newQuantity);
                    System.out.println("\nSuccessfully decreased quantity of " + item + " by " + quantityToSubtract);
                } else {
                    System.out.println("\nError: Quantity of " + item + " cannot be less than 0");
                }
                return;
            }
        }
        System.out.println("Error: Item " + item + " not found in inventory");
    }

    public void updateItemName(String item, String newItemName) {
        if (item == null || newItemName == null) {
            System.out.println("\nItem name cannot be null");
        } else {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(item)) {
                    int currentQuantity = entry.getValue();
                    inventory.remove(item);
                    inventory.put(newItemName, currentQuantity);
                    System.out.println("Successfully updated item name from " + item + " to " + newItemName);
                    return;
                }
            }
            System.out.println("\nError: Item " + item + " not found in inventory");
        }
    }

    public void deleteItem(String item) {
        if (item == null) {
            System.out.println("\nItem name cannot be null");
        } else {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(item)) {
                    inventory.remove(item);
                    System.out.println("Item " + item + " deleted");
                    return;
                }
            }
            System.out.println("Item " + item + " not found");
        }
    }

    public void showAllItem() {
        System.out.println("\nInventory List");
        if (inventory.isEmpty()) {
            System.out.println("List is Empty");
        } else {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println("Item name: " + entry.getKey());
                System.out.println("Quantity: " + entry.getValue());
            }
        }
    }

}
