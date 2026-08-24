import java.util.*;
class Application{
    static Scanner input = new Scanner (System.in);
    static String [] customerQuestions = {
        "1) Save Customer",
        "2) Update Customer",
        "3) Delete Customer",
        "4) Search Customer",
        "5) Back to Main Menu",
        "6) Exit"
    };

    static String [] customers = new String[100]; // save customer names
    static  int customerPointer = 0; // pointer to keep track of the number of customers saved    
    public static void printWelcomeNote(){
        System.out.println("===================================");
        System.out.println("Hello Welcome to CLI POS");
        System.out.println("===================================");
    }

    public static void printPrimarySection(){
        System.out.println("===================================");
        System.out.println("Choose an Option (Enter the number): ");
        System.out.println("===================================");
    }

    public static void printPrimaryQuestions(){
        System.out.println("1) Customer Management");
        System.out.println("2) Product Management");
        System.out.println("3) Order Management");
        System.out.println("4) Exit");
    }
// Customer Management Section
    public static void manageCustomer(){
        System.out.println("Manage your Customer Informations");
        System.out.println("===================================");
        System.out.println(Arrays.toString(customers));
        while(true){
        
            for (String temp : customerQuestions){
                System.out.println(temp);
            }
            int num = input.nextInt();
            input.nextLine(); // consume the newline character

            switch(num){
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

    public static void saveCustomer(){
        System.out.print("Enter Customer Name "+(customerPointer+1)+": ");
        if (customers[99]== null){
            customers[customerPointer] = input.nextLine();
            System.out.println("Customer " + customers[customerPointer]+ " Saved Successfully.");
            customerPointer++;
            
        }else{
            System.out.println("Customer List is Full.");
        }
    }

    public static void updateCustomer(){
        System.out.print("Please Enter the Customer ID: ");
        int customerIndex = input.nextInt();
        customerIndex--; // Adjust for 0-based index
        input.nextLine(); // consume the newline character

        String customerName = customers[customerIndex];
        if(customerName != null){
                System.out.println("Customer found and name is: "+customerName);
                System.out.print("Please Enter the new name: ");

                String tempName = input.nextLine();
                customers[customerIndex] = tempName;
                System.out.println("Customer name updated successfully.");
        }else{
            System.out.println("Customer not found.");
        }

    }

    public static void deleteCustomer(){
        System.out.print("Please Enter the Customer ID: ");
        int customerIndex = input.nextInt();
        customerIndex--; // Adjust for 0-based index
        input.nextLine();
        if(customers[customerIndex] != null){
            customers[customerIndex] = null;
            System.out.println("Customer deleted successfully.");
        }else{
            System.out.println("Customer not found.");
        }
    }

    public static void searchCustomer(){
        System.out.print("Please Enter the Search Text: ");
        String searchText = input.nextLine();
        for(String tempName : customers){
            if(tempName!=null && tempName.contains(searchText)){
                System.out.println("Customer found: "+tempName);
            }
        }
    }


    // Product Management Section
    public static void manageProduct(){
        
    }


    // Order Management Section
    public static void manageOrder(){
        
    }

    public static void exit(){
        
    }

    public static void main(String[] args){
        printWelcomeNote();
        printPrimarySection();

        while(true){
            printPrimaryQuestions();

            int num = input.nextInt();

            switch(num){
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