public class ListNode<E> {
    private E item;
    private ListNode<E> next;
    private ListNode<E> prev;

    public ListNode(E item){
        this.item = item;
        this.next = null;
        
    }

    public ListNode(E item, ListNode<E> next, ListNode<E> prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public E getItem(){
        return this.item;
    }

    public ListNode<E> getNext(){
        return this.next;
    }

    public ListNode<E> getPrev(){
        return this.prev;
    }

    public void setItem(E item){
        this.item = item;
    }

    public void setNext(ListNode<E> next){
        this.next = next;
    }

    public void setPrev(ListNode<E> prev){
        this.prev = prev;
    }

    public void remove(){
        if(prev != null){
            prev.next = next;
        }
        if(next != null){
            next.prev = prev;
        }
    }

    public void display(){
        System.out.println(item);
    }
}
