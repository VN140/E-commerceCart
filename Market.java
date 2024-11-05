import java.util.Scanner;

public class Market {

    /////////////////////////////////////////////// Store Manangement
    /////////////////////////////////////////////// ///////////////////////////////////////////////
    static ArrayList<Product> store = new ArrayList<>();

    public static void AddProductinStore(int ID, String name, double price, int stock) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.get(i).setQuantity(store.get(i).getQuantity() + stock);
                System.out.println("This product have already in store, then add stock");
                check = 1;
            }
        }
        if (check == 0) {
            store.add(new Product(ID, name, price, stock));
        }
    }

    public static void DeleteProductinStore(int ID) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.delete(store.get(i).getName());
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in store.");
        }
    }

    public static void AddStockinStore(int ID, int stock) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.get(i).setQuantity(store.get(i).getQuantity() + stock);
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in store.");
        }
    }

    public static void IncreasStockinStore(int ID, int stock) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.get(i).setQuantity(store.get(i).getQuantity() + stock);
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in store.");
        }
    }

    public static void DecreaseStockinStore(int ID, int stock) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                if ((store.get(i).getQuantity() - stock) <= 0) {
                    store.get(i).setQuantity(0);
                    check = 1;
                    break;
                }
                store.get(i).setQuantity(store.get(i).getQuantity() - stock);
                check = 2;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in store.");
        }
    }

    public static void RemoveStockinStore(int ID) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.get(i).setQuantity(0);
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in stock.");
        }
    }

    public static void addDescriptionProductinStore(int ID, String sentence) {
        int check = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                store.get(i).addDescription(sentence);
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("Does not have this product in store.");
        }
    }

    public static void displayProductinStore() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\t\t         All product in this store:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|ID\t| Name\t\t| Price\t\t| Stock\t\t| Description\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < store.size(); i++) {
            System.out.println(store.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void updateProductinStore() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\t\t       Update product in this store:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|ID\t| Name\t\t| Price\t\t| Stock\t\t| Description\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < store.size(); i++) {
            System.out.println(store.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    //////////////////////////////////////////////// Cart Management
    //////////////////////////////////////////////// ////////////////////////////////////////////////
    static LinkedList<Product> cart = new LinkedList<>();

    public static void AddProductinCart(int ID, int quantity) {
        int check = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getID() == ID) {
                System.out.println("This product already have in cart, then will increase quantity.");
                Market.IncreaseQuantityinCart(ID, quantity);
                check = 1;
            }
        }
        int quanchec = 0;
        for(int i=0;i<store.size();i++){
            if(store.get(i).getID() == ID){
                quanchec = store.get(i).getQuantity();
            }
        }
        if (check == 0) {
            int have = 0;
            for (int i = 0; i < store.size(); i++) {
                if(store.get(i).getID() == ID && quanchec < quantity){
                    have = 3;
                }else if (store.get(i).getID() == ID && store.get(i).getQuantity() != 0) {
                    cart.add(new Product(ID, store.get(i).getName(), store.get(i).getPrice(), quantity,
                            store.get(i).getDescription()));
                    have = 1;
                } else if (store.get(i).getID() == ID && store.get(i).getQuantity() == 0) {
                    have = 2;
                }
            }
            if (have == 0) {
                System.out.println("Does not have this product in store.");
            } else if (have == 2) {
                System.out.println("This product does not have in stock");
            } else if (have == 3) {
                System.out.println("Cannot add quantity becuase product in stock does not have enough");
            }
        }
    }

    public static void RemoveProductinCart(int ID) {
        int have = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getID() == ID) {
                cart.setNext(cart.getNext());
                cart.remove(cart.get(i));
                have = 1;
            }
        }
        if (have == 0) {
            System.out.println("Does not have this product in cart.");
        }
    }

    public static void ChangeQuantityinCart(int ID, int quantity) {
        int have = 0;
        int quanchec = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                quanchec = store.get(i).getQuantity();
            }
        }
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getID() == ID) {
                if (quantity > quanchec) {
                    System.out.println("Cannot change quantity becuase product in stock does not have enough");
                    have = 2;
                    break;
                }
                cart.get(i).setQuantity(quantity);
                have = 1;
            }
        }
        if (have == 0) {
            System.out.println("Does not have this product in cart.");
        }
    }

    public static void IncreaseQuantityinCart(int ID, int quantity) {
        int have = 0;
        int quanchec = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getID() == ID) {
                quanchec = store.get(i).getQuantity();
            }
        }
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getID() == ID) {
                if (cart.get(i).getQuantity() + quantity > quanchec) {
                    System.out.println("Cannot add quantity because product in stock does not have enough.");
                    have = 2;
                    break;
                }
                cart.get(i).setQuantity(cart.get(i).getQuantity() + quantity);
                have = 1;
            }
        }
        if (have == 0) {
            System.out.println("Does not have this product in cart.");
        }
    }

    public static void DecreaseQuantityinCart(int ID, int quantity) {
        int have = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getID() == ID) {
                if ((cart.get(i).getQuantity() - quantity) <= 0) {
                    Market.RemoveProductinCart(ID);
                    break;
                }
                cart.get(i).setQuantity(cart.get(i).getQuantity() - quantity);
                have = 1;
            }
        }
        if (have == 0) {
            System.out.println("Does not have this product in cart.");
        }
    }

    public static void SortingProductinCart() {
        for (int i = 0; i < cart.size(); i++) {
            int index = i;
            for (int j = 1; j < cart.size(); j++) {
                if (cart.get(j).getID() < cart.get(i).getID()) {
                    index = j;
                }
                Product p = new Product(cart.get(i).getID(), cart.get(i).getName(), cart.get(i).getPrice(),
                        cart.get(i).getQuantity());
                p.addDescription(cart.get(i).getDescription());
                cart.get(i).setAll(cart.get(index));
                cart.get(index).setAll(p);
            }
        }
    }

    public static double getAllTotalPriceinCart() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice() * cart.get(i).getQuantity();
        }
        return total;
    }

    //////////////////////////////////////////////// User cart Management
    //////////////////////////////////////////////// ////////////////////////////////////////////////

    static int out = 0;

    public static int UserEnter(String enter) {
        if (enter.equals("1")) {
            System.out.println();
            System.out.println("Welcome to Store ^^");
            System.out.println();
            System.out.println("Please, select the product ^^");
            System.out.println();
            System.out.println("To select the product, you can insert product ID to add into your cart.");
            if(out == 0){
                return 0;
            }else return 1;
        } else {
            System.out.println();
            System.out.println("You can go anywhere else.");
            return 1;
        }
    }

    public static int UserShopping(int choice) {
        if (choice == 1) {
            Scanner sc = new Scanner(System.in);
            Market.displayProductinStore();
            System.out.print("Insert Product ID -> ");
            String ID = sc.nextLine();
            System.out.print("Insert Quantity -> ");
            String quantity = sc.nextLine();
            try{
                int realID = Integer.parseInt(ID);
                int realQuantity = Integer.parseInt(quantity);
                Market.AddProductinCart(realID, realQuantity);
            }catch(NumberFormatException e){
                System.out.println("Sorry, the input that you insert does not match will the program.");
            }
            if(out == 0) return 0;
            else return 1;
        } else if (choice == 2) {
            System.out.println();
            System.out.println("Please, Go to counter to checkout");
            out = 1;
            if(out == 0) return 0;
            else return 1;
        } else if (choice == 3) {
            Market.displayProductinCart();
            System.out.println();
            System.out.println("OK and Checkout -> Enter <1>");
            System.out.println("Continue Shopping -> Enter <2>");
            System.out.println("Edit Cart -> Enter <3>");
            System.out.print("Your choice -> ");
            Scanner sc = new Scanner(System.in);
            Market.DisplayandConfirmCartuser(sc.nextLine());
            if(out == 0) return 0;
            else return 1;
        } else {
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.UserShopping(3);
            if(out == 0) return 0;
            else return 1;
        }
    }

    public static int DisplayandConfirmCartuser(String choice) {
        if (choice.equals("1")) {
            Market.UserShopping(2);
            if(out == 0) return 0;
            else return 1;
        } else if (choice.equals("2")) {
            Market.UserShopping(1);
            if(out == 0) return 0;
            else return 1;
        } else if (choice.equals("3")) {
            Market.displayProductinCart();
            System.out.println("Back -> Enter <0>");
            System.out.println("Add Quantity -> Enter <1>");
            System.out.println("Reduce Quantity -> Enter <2>");
            System.out.println("Remove Product -> Enter <3>");
            System.out.print("Your choice -> ");
            Scanner sc = new Scanner(System.in);
            Market.EditusercartandConfirm(sc.nextLine());
            if(out == 0) return 0;
            else return 1;
        } else {
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.UserShopping(3);
            if(out == 0) return 0;
            else return 1;
        }
    }

    public static void EditusercartandConfirm(String choice) {
        if (choice.equals("1")) {
            Scanner sc = new Scanner(System.in);
            Market.displayProductinCart();
            System.out.print("Insert Product ID -> ");
            String ID = sc.nextLine();
            System.out.print("Insert Quantity -> ");
            String quantity = sc.nextLine();
            try{
                int realID = Integer.parseInt(ID);
                int realQuantity = Integer.parseInt(quantity);
                Market.IncreaseQuantityinCart(realID, realQuantity);
            }catch(NumberFormatException e){
                System.out.println("Sorry, the input that you insert does not match will the program.");
            }
            Market.UserShopping(3);
        } else if (choice.equals("2")) {
            Scanner sc = new Scanner(System.in);
            Market.displayProductinCart();
            System.out.print("Insert Product ID -> ");
            String ID = sc.nextLine();
            System.out.print("Insert Quantity -> ");
            String quantity = sc.nextLine();
            try{
                int realID = Integer.parseInt(ID);
                int realQuantity = Integer.parseInt(quantity);
                Market.DecreaseQuantityinCart(realID, realQuantity);
            }catch(NumberFormatException e){
                System.out.println("Sorry, the input that you insert does not match will the program.");
            }
            Market.UserShopping(3);
        } else if (choice.equals("3")) {
            Scanner sc = new Scanner(System.in);
            Market.displayProductinCart();
            System.out.print("Insert Product ID -> ");
            String ID = sc.nextLine();
            try{
                int realID = Integer.parseInt(ID);
                Market.RemoveProductinCart(realID);
            }catch(NumberFormatException e){
                System.out.println("Sorry, the input that you insert does not match will the program.");
            }
            Market.UserShopping(3);
        } else if (choice.equals("0")){
            Market.UserShopping(3);
        }
        else {
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.UserShopping(3);
        }
    }
    public static void displayProductinCart() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\t\t         All product in your cart:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        cart.displayList();
        System.out.println("---------------------------------------------------------------------------------");
        double total = getAllTotalPriceinCart();
        System.out.println("Total Price: " + total);
    }

    //////////////////////////////////////////////// Checkout Process
    //////////////////////////////////////////////// ////////////////////////////////////////////////

    static int outdoor = 0;
    public static int checkout() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\t\t        All product in your cart:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        cart.displayList();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Total Price is " + Market.getAllTotalPriceinCart() + " Baht." + " Please purchase for your product!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have discount code?");
        System.out.println("Back -> Enter <0>");
        System.out.println("Yes -> Enter <1>");
        System.out.println("No -> Enter <2>");
        System.out.print("Your choice -> ");
        double newTotal = Market.CheckDiscount(sc.nextLine());
        int check = 0;
        check = Market.confirmUser();
        if(check == 0){
            if(outdoor == 0) return 0;
            else return 1;
        }
        else{
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("\t\t        All product in your cart:");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
            System.out.println("---------------------------------------------------------------------------------");
            cart.displayList();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Total Price is " + newTotal + " Baht." + " Please purchase for your product!!");
        
            for (int i = 0; i < cart.size(); i++) {
                for (int j = 0; j < store.size(); j++) {
                    if (store.get(j).getID() == cart.get(i).getID()) {
                        store.get(j).setQuantity(store.get(j).getQuantity() - cart.get(i).getQuantity());
                    }
                }
            }
            if(outdoor == 0) return 0;
            else return 1;
        }
        
    }

    public static double CheckDiscount(String choice){
        if(choice.equals("1")){
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter discount code: ");
            String discount = sc.next();
            if(discount.equals("TENPERCENT")){
                double newTotalprice = 0;
                newTotalprice = Market.getAllTotalPriceinCart() - (Market.getAllTotalPriceinCart() * 10)/100;
                System.out.println();
                System.out.println("Discount complete");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\t\t        All product in your cart:");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                cart.displayList();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Total Price is " + newTotalprice + " Baht." + " Please purchase for your product!!");
                return newTotalprice;
            }
            else if(discount.equals("FIVEPERCENT")){
                double newTotalprice = 0;
                newTotalprice = Market.getAllTotalPriceinCart() - (Market.getAllTotalPriceinCart() * 5)/100;
                System.out.println();
                System.out.println("Discount complete");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\t\t        All product in your cart:");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                cart.displayList();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Total Price is " + newTotalprice + " Baht." + " Please purchase for your product!!");
                return newTotalprice;
            }
            else {
                System.out.println();
                System.out.println("This discount does not exist.");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\t\t        All product in your cart:");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|ID\t| Name\t\t| Price\t\t| Quantity\t| Description\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                cart.displayList();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Total Price is " + Market.getAllTotalPriceinCart() + " Baht." + " Please purchase for your product!!");
                return Market.getAllTotalPriceinCart();
            }
        }
        else if(choice.equals("2")){
            return Market.getAllTotalPriceinCart();
        }
        else if(choice.equals("0")){
            Market.UserShopping(3);
            return Market.getAllTotalPriceinCart();
        }
        else{
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.checkout();
            return Market.getAllTotalPriceinCart();
        }
    }

    public static int confirmUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("You are going to checkout, are you sure?");
        System.out.println("Sure -> Enter 'Yes'");
        System.out.println("Not yet -> Enter 'No'");
        System.out.print("Your choice -> ");
        String choice = sc.nextLine();
        if(choice.equals("Yes")){
            outdoor = 1;
            if(outdoor == 0) return 0;
            else return 1;
        }
        else if(choice.equals("No")){
            if(outdoor == 0) return 0;
            else return 1;
        }else{
            System.out.println("Sorry, the input that you insert does not match will the program.");
            confirmUser();
            if(outdoor == 0) return 0;
            else return 1;
        }
    }

    //////////////////////////////////////////////// Manager Mode
    //////////////////////////////////////////////// ////////////////////////////////////////////////

    static int outmode = 0;
    public static int login(){
        System.out.print("Enter password -> ");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if(password.equals("ILOVEICT")){
            System.out.println();
            System.out.println("Welcome to Manage Mode");
            return 0;
        }
        return 1;
    }

    public static int ManageProduct(String choice){
        if(choice.equals("0")){
            Market.displayProductinStore();
            System.out.println("Exit Manager Mode -> Enter <0>");
            System.out.println("Add Product -> Enter <1>");
            System.out.println("Remove Prouct -> Enter <2>");
            System.out.println("Manager Quantity -> Enter <3>");
            System.out.print("Your choice -> ");
            Scanner sc = new Scanner(System.in);
            String CMP = sc.nextLine();
            if(CMP.equals("1")){
                Market.AddProductbyManager();
            } else if(CMP.equals("2")){
                Market.RemoveProductbyManager();
            }else if(CMP.equals("3")){
                Market.ManageStockbyManager();
            }else if(CMP.equals("0")){
                return Market.OutofManagerMode();
            }else {
                System.out.println("Sorry, the input that you insert does not match will the program.");
                Market.ManageProduct("0");
            }
        }
        return 0;       
    }

    public static void AddProductbyManager(){
        Market.displayProductinStore();
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Product ID -> ");
        String ID = sc.nextLine();
        System.out.print("Insert Product name -> ");
        String name = sc.nextLine();
        System.out.print("Insert Product price -> ");
        String price = sc.nextLine();
        System.out.print("Insert Stock -> ");
        String stock = sc.nextLine();
        System.out.print("Insert Product description -> ");
        String description = sc.nextLine();
        try{
            int realID = Integer.parseInt(ID);
            int realStock = Integer.parseInt(stock);
            int realPrice = Integer.parseInt(price);
            Market.AddProductinStore(realID, name, realPrice, realStock);
            Market.addDescriptionProductinStore(realID, description);
            Market.ManageProduct("0");
        }catch (NumberFormatException e){
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.ManageProduct("0");
        }
    }

    public static void RemoveProductbyManager(){
        Market.displayProductinStore();
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Product ID -> ");
        String ID = sc.nextLine();
        try{
            int realID = Integer.parseInt(ID);
            Market.RemoveStockinStore(realID);
            Market.ManageProduct("0");
        }catch (NumberFormatException e){
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.ManageProduct("0");
        }
    }

    public static void ManageStockbyManager(){
        Market.displayProductinStore();
        System.out.println("Add Quantity -> Enter <1>");
        System.out.println("Reduce Quantity -> Enter <2>");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("1")){
            Market.AddStockinStorebyManager();
        }else if(choice.equals("2")){
            Market.ReduceStockinStorebyManager();
        }else{
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.ManageProduct("0");
        }
    }

    public static void AddStockinStorebyManager(){
        Market.displayProductinStore();
        System.out.print("Insert Product ID -> ");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        System.out.print("Insert Quantity -> ");
        String quantity = sc.nextLine();
        try{
            int realID = Integer.parseInt(ID);
            int realQuantity = Integer.parseInt(quantity);
            Market.AddStockinStore(realID, realQuantity);
            Market.ManageProduct("0");
        }catch (NumberFormatException e){
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.ManageProduct("0");
        }
    }

    public static void ReduceStockinStorebyManager(){
        Market.displayProductinStore();
        System.out.print("Insert Product ID -> ");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        System.out.print("Insert Quantity -> ");
        String quantity = sc.nextLine();
        try{
            int realID = Integer.parseInt(ID);
            int realQuantity = Integer.parseInt(quantity);
            Market.DecreaseStockinStore(realID, realQuantity);
            Market.ManageProduct("0");
        }catch (NumberFormatException e){
            System.out.println("Sorry, the input that you insert does not match will the program.");
            Market.ManageProduct("0");
        }
    }

    public static int OutofManagerMode(){
        return 1;
    }
}