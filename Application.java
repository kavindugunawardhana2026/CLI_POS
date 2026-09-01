import java.util.*;

class Application {
    static Scanner input = new Scanner(System.in);
    static String[] customerQuestions = {
            "1) Save Customer",
            "2) Update Customer",
            "3) Delete Customer",
            "4) Search Customer",
            "5) Back to Main Menu",
            "6) Exit"
    };

    static String[] productQuestions = {
            "1) Save Product",
            "2) Update Product",
            "3) Delete Product",
            "4) Search Product",
            "5) Back to Main Menu",
            "6) Exit"
    };

    static String[] orderQuestions = {
            "1) Place Order",
            "2) View all Order",
            "3) Delete Order",
            "4) Back to Home",
            "5) Exit"
    };

    static String[] customers = new String[100]; // save customer names
    static String[] products = new String[100]; // save product names
    static double[] productPrices = new double[100];
    static int[] productStocks = new int[100];
    static String[] orders = new String[100];
    static int orderCounter = 0; // pointer to keep track of the number of orders saved
    static int customerPointer = 0; // pointer to keep track of the number of customers saved
    static int productPointer = 0; // pointer to keep track of the number of products saved

    public static void printDivider() {
        System.out.println("===================================");
    }

    public static void printWelcomeNote() {
        System.out.println("===================================");
        System.out.println("Hello Welcome to CLI POS");
        System.out.println("===================================");
    }

    public static void printPrimarySection() {
        System.out.println("===================================");
        System.out.println("Choose an Option (Enter the number): ");
        System.out.println("===================================");
    }

    public static void printPrimaryQuestions() {
        System.out.println("1) Customer Management");
        System.out.println("2) Product Management");
        System.out.println("3) Order Management");
        System.out.println("4) Exit");
    }

    // Customer Management Section
    public static void manageCustomer() {
        System.out.println("Manage your Customer Informations");
        System.out.println("===================================");
        System.out.println(Arrays.toString(customers));
        while (true) {

            for (String temp : customerQuestions) {
                System.out.println(temp);
            }
            int num = input.nextInt();
            input.nextLine(); // consume the newline character

            switch (num) {
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                case 5:
                case 6:
                default:

            }
        }

    }

    public static void saveCustomer() {
        System.out.print("Enter Customer Name " + (customerPointer + 1) + ": ");
        if (customers[99] == null) {
            customers[customerPointer] = input.nextLine();
            System.out.println("Customer " + customers[customerPointer] + " Saved Successfully.");
            customerPointer++;

        } else {
            System.out.println("Customer List is Full.");
        }
    }

    public static void updateCustomer() {
        System.out.print("Please Enter the Customer ID: ");
        int customerIndex = input.nextInt();
        customerIndex--; // Adjust for 0-based index
        input.nextLine(); // consume the newline character

        String customerName = customers[customerIndex];
        if (customerName != null) {
            System.out.println("Customer found and name is: " + customerName);
            System.out.print("Please Enter the new name: ");

            String tempName = input.nextLine();
            customers[customerIndex] = tempName;
            System.out.println("Customer name updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }

    }

    public static void deleteCustomer() {
        System.out.print("Please Enter the Customer ID: ");
        int customerIndex = input.nextInt();
        customerIndex--; // Adjust for 0-based index
        input.nextLine();
        if (customers[customerIndex] != null) {
            customers[customerIndex] = null;
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void searchCustomer() {
        System.out.print("Please Enter the Search Text: ");
        String searchText = input.nextLine();
        for (String tempName : customers) {
            if (tempName != null && tempName.contains(searchText)) {
                System.out.println("Customer found: " + tempName);
            }
        }
    }

    public static void loadAllCustomer(){
        for(String tempName : customers){
            System.out.println(tempName);
        }
    }

    public static void loadAllProducts(){
        for(String tempName : products){
            System.out.println(tempName);
        }
    }

    // Product Management Section
    public static void manageProduct() {
        System.out.println("Manage your Product Informations");
        System.out.println("===================================");

        while (true) {
            for (String temp : productQuestions) {
                System.out.println(temp);
            }
            System.out.print("Enter your choice: ");
            int num = input.nextInt();
            input.nextLine(); // consume the newline character

            switch (num) {
                case 1:
                    saveProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    return; // Back to Main Menu
                case 6:
                    exit();
                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        }
    }

    public static void saveProduct() {
        System.out.print("Enter the Product Name " + (productPointer + 1) + ": ");
        if (products[99] == null) {
            products[productPointer] = input.nextLine();
            System.out.print("Enter product price: ");
            double price = input.nextDouble();
            input.nextLine(); // consume the newline character
            productPrices[productPointer] = price;

            System.out.print("Enter product QTY: ");
            int qty = input.nextInt();
            input.nextLine(); // consume the newline character
            productStocks[productPointer] = qty;

            System.out.println("Product " + products[productPointer] + " Saved Successfully.");
            productPointer++;
        } else {
            System.out.println("Product List is Full.");
        }
    }

    public static void updateProduct() {
        System.out.println("Enter the Product ID: ");
        int productIndex = input.nextInt();
        input.nextLine(); // consume the newline character
        productIndex--; // Adjust for 0-based index
        if (productIndex >= 0 && productIndex < products.length && products[productIndex] != null) {
            System.out.println("Product found and name is: " + products[productIndex]);
            System.out.print("Please Enter the new name: ");
            String tempName = input.nextLine();
            products[productIndex] = tempName;
            System.out.println("Product name updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct() {
        System.out.println("Enter the Product Index to delete: ");
        int productIndex = input.nextInt();
        input.nextLine(); // consume the newline character
        productIndex--; // Adjust for 0-based index
        if (products[productIndex] != null) {
            products[productIndex] = null;
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void searchProduct() {
        System.out.println("Enter text to search: ");
        String searchText = input.nextLine();
        for (String product : products) {
            if (product != null && product.contains(searchText)) {
                System.out.println("Product found: " + searchText);
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    // Order Management Section
    public static void placeOrder(){
        loadAllCustomer();
        System.out.print("Enter customer ID: ");
        int cIdx = input.nextInt()-1;
        input.nextLine();

        if(cIdx<0 || cIdx >= customerPointer || customers[cIdx]==null){
            System.out.println("Customer not found");
            return;
        }

        loadAllProducts();
        System.out.print("Enter product ID: ");
        int pIdx = input.nextInt()-1;
        input.nextLine();

        if(pIdx<0 || pIdx >= productPointer || customers[pIdx]==null){
            System.out.println("Product not found");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = input.nextInt();
        input.nextLine();
        if(qty<=0){
            System.out.println("Invalid quantity");
            return;
        }

        if(productStocks[pIdx]<qty){
            System.out.println("Not enough stock");
            return;
        }

        double totalPrice = productPrices[pIdx]*qty;
        productStocks[pIdx]-=qty;
        String orderSummery = String.format(
            "Order#%d | Customer: %s | Product: %s | QTY: %d | Total: LKR%.2f",
            (orderCounter+1),
            customers[cIdx],
            products[pIdx], 
            qty,
            totalPrice
        );

        orders[orderCounter]=orderSummery;
        orderCounter++;
        System.out.println("Order placed successfully");
    }

    public static void viewAllOrders(){
        System.out.println("--------------All Orders--------------");
        if(orderCounter==0){
            System.out.println("No orders found");
            return;
        }
        boolean any = false;
        for(int i=0;i<orderCounter;i++){
            if(orders[i]!=null){
                any = true;
                System.out.println(orders[i]);
            }
        }
        if(!any){
            System.out.println("No orders found");
        }
    }

    public static void deleteOrder(){
        viewAllOrders();
        System.out.print("Enter order ID to delete: ");
        int oIdx = input.nextInt()-1;
        input.nextLine();
        if(oIdx<0 || oIdx >= orderCounter || orders[oIdx]==null){
            System.out.println("Order not found");
            return;
        }
        orders[oIdx]=null;
        System.out.println("Order deleted successfully");
    }

    

    public static void manageOrder() {
        while (true) {
            printDivider();
            System.out.println("Order Management");
            printDivider();
            for (String q : orderQuestions) {
                System.out.println(q);
            }
            System.out.println("Choice: ");
            int num = input.nextInt();
            input.nextLine();
            switch (num) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    return;
                case 5:
                    exit();
                    break;
                default:
                    System.out.print("Invalid choice, try again");

            }
        }
    }

    public static void exit() {
        System.out.println("Good bye!...");
        System.exit(0);
    }

    public static void main(String[] args) {
        printWelcomeNote();
        printPrimarySection();

        while (true) {
            printPrimaryQuestions();

            int num = input.nextInt();

            switch (num) {
                case 1:
                    manageCustomer();
                    break;

                case 2:
                    manageProduct();
                    break;

                case 3:
                    manageOrder();
                    break;

                case 4:
                    exit();

                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }

        }

    }

}