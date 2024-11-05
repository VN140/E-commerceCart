import java.util.Scanner;

public class MainTest{
    public static void main(String[] args){
        
        Market.AddProductinStore(14, "Cola", 20, 100);
        Market.AddProductinStore(28, "Oishi", 15, 200);
        Market.AddProductinStore(32, "Gato", 15, 150);
        Market.AddProductinStore(57, "Sprite", 18, 200);
        Market.AddProductinStore(178, "Evian", 60, 50);
        Market.addDescriptionProductinStore(14, "Soft Drink");
        Market.addDescriptionProductinStore(28, "Sugar Drink");
        Market.addDescriptionProductinStore(32, "Sugar Drink");
        Market.addDescriptionProductinStore(57, "Soft Drink");
        Market.addDescriptionProductinStore(178, "Mineral Water");

        Scanner user = new Scanner(System.in);
        int checkin = 0;
        String enter = null;
        while(checkin == 0){
            System.out.println();
            System.out.println("Do you want to enter to the store?");
            System.out.println("Enter the store -> Enter <1>");
            System.out.println("Just walk by -> Enter <2>");
            System.out.print("Your choice -> ");
            enter = user.nextLine();
            if(enter.equals("69")){
                int check = Market.login();
                if(check == 0){
                    checkin = Market.ManageProduct("0");
                }
                else if(check == 1){
                    System.out.println("Password Incorrect");
                }
            }
            else{
                checkin = 1;
                break;
            }
        }
        if(checkin == 1){
            int check = Market.UserEnter(enter);
            if(check == 0){
                Market.displayProductinStore();
                System.out.print("Insert product ID -> ");
                String pickup = user.nextLine();
                System.out.print("Insert Quantity -> ");
                String howmuch = user.nextLine();
                try{
                    int ID = Integer.parseInt(pickup);
                    int quantity = Integer.parseInt(howmuch);
                    Market.AddProductinCart(ID, quantity);
                }catch(NumberFormatException e){
                    System.out.println("Sorry, the input that you insert does not match will the program.");
                }
                while(check == 0){
                    Market.displayProductinCart();
                    System.out.println();
                    System.out.println("OK and Checkout -> Enter <1>");
                    System.out.println("Continue Shopping -> Enter <2>");
                    System.out.println("Edit Cart -> Enter <3>");
                    System.out.print("Your choice -> ");
                    check = Market.DisplayandConfirmCartuser(user.nextLine()); // POTOTYPE 1
                    if(check == 1){
                        check = Market.checkout();
                        if(check == 1){
                            break;
                        }
                    }
                }
            }   
        }
    }
}
