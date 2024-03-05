import java.util.Scanner;
public class OnlineShopping {

    // Declare and initialize the menu items, prices and numbers as arrays
    static String[] menuItems = {"Cake", "Cookie", "Muffin", "Pie", "Brownie", "Donut", "Croissant", "Scone", "Cupcake", "Macaron"};
    static double[] menuPrices = {4.50, 2.00, 3.00, 5.00, 3.50, 2.50, 4.00, 3.00, 4.00, 5.00};
    static int[] menuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Declare and initialize the GST rate
    static double gst = 0.18;

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Declare and initialize variables
        int n; // number of items
        double subtotal = 0.0; // subtotal of the items
        double tax = 0.0; // tax amount
        double total = 0.0; // total bill amount

        // Display the menu items, prices and numbers
        System.out.println("Online Shopping Menu");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-10s %-20s %10s\n", "Number", "Item", "Price");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%-10d %-20s %10.2f\n", menuNumbers[i], menuItems[i], menuPrices[i]);
        }
        System.out.println("-----------------------------------------------------------");

        // Prompt the user to enter the number of items
        System.out.print("Enter the number of items (up to 10): ");
        n = sc.nextInt();

        // Validate the input
        if (n < 1 || n > 10) {
            System.out.println("Invalid number of items. Please try again.");
            return;
        }

        // Create arrays to store the item names, prices and quantities
        String[] itemNames = new String[n];
        double[] itemPrices = new double[n];
        int[] itemQuantities = new int[n];

        // Loop through the items and get their names, prices and quantities from the user
        for (int i = 0; i < n; i++) {
            // Prompt the user to enter the item number
            System.out.print("Enter the number of item " + (i + 1) + ": ");
            int itemNumber = sc.nextInt();

            // Validate the item number
            if (!isValidNumber(itemNumber)) {
                System.out.println("Invalid item number. Please try again.");
                return;
            }

            // Get the item name and price from the menu
            itemNames[i] = getName(itemNumber);
            itemPrices[i] = getPrice(itemNumber);

            // Prompt the user to enter the item quantity
            System.out.print("Enter the quantity of item " + (i + 1) + ": ");
            itemQuantities[i] = sc.nextInt();

            // Add the item price times quantity to the subtotal
            subtotal += itemPrices[i] * itemQuantities[i];
        }

        // Calculate the tax and total amount
        tax = subtotal * gst;
        total = subtotal + tax;

        // Display the shopping list with item, price and quantity
        System.out.println("\nOnline Shopping List");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %10s %10s\n", "Number", "Item", "Price", "Quantity");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-20s %10.2f %10d\n", menuNumbers[i], itemNames[i], itemPrices[i], itemQuantities[i]);
        }
        System.out.println("--------------------------------------------------------------------------");

        // Display the subtotal, tax and total bill
        System.out.printf("%-30s %10.2f\n", "Subtotal", subtotal);
        System.out.printf("%-30s %10.2f\n", "GST (" + (gst * 100) + "%)", tax);
        System.out.printf("%-30s %10.2f\n", "Total", total);
    }

    // A method to check if the item number is valid
    public static boolean isValidNumber(int number) {
        for (int num : menuNumbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    // A method to get the item name from the menu
    public static String getName(int number) {
        for (int i = 0; i < menuNumbers.length; i++) {
            if (menuNumbers[i] == number) {
                return menuItems[i];
            }
        }
        return null;
    }

    // A method to get the item price from the menu
    public static double getPrice(int number) {
        for (int i = 0; i < menuNumbers.length; i++) {
            if (menuNumbers[i] == number) {
                return menuPrices[i];
            }
        }
        return 0.0;
    }
}



