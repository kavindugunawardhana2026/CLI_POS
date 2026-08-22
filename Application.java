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

    public static void manageCustomer(){
        System.out.println("Manage your Customer Informations");

        while(true){
            for (String temp : customerQuestions){
                System.out.println(temp);
            }
            int num = input.nextInt();

            switch(num){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    
            }
        }

    }

    public static void manageProduct(){
        
    }

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