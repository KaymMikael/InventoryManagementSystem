import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        InventoryManagementSystem ims = InventoryManagementSystem.getInstance();
        sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Search Item");
            System.out.println("3. Decrease Quantity");
            System.out.println("4. Update Item Name");
            System.out.println("5. Delete Item");
            System.out.println("6. Show All Items");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();
                showChoices(ims, choice);
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    private static void showChoices(InventoryManagementSystem ims, int ch) {
        switch (ch) {
            case 1:
                System.out.print("Enter item name: ");
                String addItemName = sc.nextLine();
                System.out.print("Enter quantity: ");
                int addQuantity = sc.nextInt();
                ims.addItem(addItemName, addQuantity);
                break;
            case 2:
                System.out.print("Enter item name to search: ");
                String searchItemName = sc.nextLine();
                ims.searchItem(searchItemName);
                break;
            case 3:
                System.out.print("Enter item name to decrease quantity: ");
                String decreaseItemName = sc.nextLine();
                System.out.print("Enter quantity to subtract: ");
                int decreaseQuantity = sc.nextInt();
                ims.decreaseQuantity(decreaseItemName, decreaseQuantity);
                break;
            case 4:
                System.out.print("Enter item name to update: ");
                String updateItemName = sc.nextLine();
                System.out.print("Enter new item name: ");
                String newItemName = sc.nextLine();
                ims.updateItemName(updateItemName, newItemName);
                break;
            case 5:
                System.out.print("Enter item name to delete: ");
                String deleteItemName = sc.nextLine();
                ims.deleteItem(deleteItemName);
                break;
            case 6:
                ims.showAllItem();
                break;
            case 7:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
        }
    }
}
