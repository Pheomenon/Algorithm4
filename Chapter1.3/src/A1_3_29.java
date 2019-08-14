import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author:Gao
 * @Date:2019-08-11 10:18
 */
/*
用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点的链接为空，
且只要链表非空则last.next的值为first.只能使用一个Node类型的实例变量(last)
 */
public class A1_3_29 {
    public static void main(String[] args) {
        Queue329<Integer> queue = new Queue329<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(queue.last.item);
            queue.last = queue.last.next;
        }



    }
}
class Queue329<Item> implements Iterable<Item>{
    class Node{
        Item item;
        Node next;
    }
    Node last;
    int N=0;
    public boolean isEmpty() {
        return N == 0;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())  last.next = last;
        else{
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
        }
    public Item Dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();}
    public class ListIterator<Item> implements Iterator<Item> {
        private Node current;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() { }

    }

}
