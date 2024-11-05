public class ArrayList<E>{
    private int size;
    private Object goods[];
    private static final int DEFAULT = 10;
        
    public ArrayList(){
        this.goods = new Object[DEFAULT];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void resize(){
        int newsize = goods.length;
        newsize++;
        Object[] newarray = new Object[newsize];
        System.arraycopy(goods, 0, newarray, 0, goods.length);
        goods = newarray;
    }

    public void add(E product){
        if(size == goods.length){
            resize();
        }
        goods[size++] = product;
    }

    public void delete(String name){
        int have = 0;
        for(int i=0;i<size;i++){
            if(goods[i] instanceof Product){
                Product check = (Product) goods[i];
                if(check.getName().equals(name)){
                    System.arraycopy(goods, i + 1, goods, i, size - i - 1);
                    goods[--size] = null;
                    have++;
                }
            }
        }
        if(have == 0){
            System.out.println("Does not have product that name" + name + " in the store.");
        }
    }

    public void set(int index, E product){
        this.goods[index] = product;
    }

    public E get(int x){
        return (E) this.goods[x];
    }
}
