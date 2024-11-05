public class Product{
    int ID;
    String name;
    String description;
    double price;
    int quantity;
    public Product(int ID, String name, double price, int quantity){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = null;
    }

    public Product(int ID, String name, double price, int quantity, String description){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getDescription(){
        return this.description;
    }

    public void addDescription(String sentence){
        this.description = sentence;
    }

    public void setAll(Product p){
        this.ID = p.getID();
        this.name = p.getName();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        this.description = p.getDescription();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString(){
        String format = null;
        if(this.getDescription().length() > 12){
            format = String.format("|%-6s | %-13s | %-13s | %-13s | %4s \t|", this.ID, this.name, this.price, this.quantity, this.description);
        }
        else{
            format = String.format("|%-6s | %-13s | %-13s | %-13s | %4s \t\t|", this.ID, this.name, this.price, this.quantity, this.description);
        }
        return format;
    }
}
