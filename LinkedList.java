public class LinkedList<E>{
    private ListNode<E> front;

    public LinkedList(){
        front = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public ListNode<E> getNext(){
        return front;
    }

    public void setNext(ListNode<E> next){
        front = next;
    }

    public boolean contains(E target){
        for(ListNode<E> node = front; node != null; node = node.getNext()){
            if(node.getItem().equals(target)){
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        ListNode<E> node = front;
        for(int i=0;i<index;i++){
            node = node.getNext();
        }
        return node.getItem();
    }

    public void set(int index, E target){
        ListNode<E> node = front;
        for(int i=0;i<index;i++){
            node = node.getNext();
        }
        node.setItem(target);
    }

    public int size(){
        int tally = 0;
        for(ListNode<E> node = front; node != null; node = node.getNext()){
            tally ++;
        }
        return tally;
    }

    public void add(E target){
        if(isEmpty()){
            front = new ListNode<E>(target);
        }
        else{
            ListNode<E> last = front;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(new ListNode<E>(target));
        }
    }

    public boolean remove(E target){
        if(front == null){
            return false;
        }
        if(front.getItem().equals(target)){
            front = front.getNext();
            return true;
        }
        ListNode<E> node = front;
        ListNode<E> prev = null;
        while (node != null && !node.getItem().equals(target)){
            prev = node;
            node = node.getNext();
        }
        if(node != null){
            prev.setNext(node.getNext());
            return true;
        }
        return false;
    }

    public void displayList(){
        ListNode<E> node = front;
        while(node != null){
            node.display();
            node = node.getNext();
        }
    }

    public String toString(){
        String result = "( ";
        for(ListNode<E> node = front; node != null; node = node.getNext()){
            result += node.getItem() + " ";
        }
        return result + ")";
    }
}
