import java.io.File;
import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-16 19:16
 */
/*
复制队列。编写一个新的的构造函数，使以下代码
Queue<Item> r = new Queue<Item>(q)
得到的r指向队列的一个新的独立的副本。可以对q或r进行任意入列或出列的操作但它们不会
相互影响。提示：从q中取出所有的元素再将它们插入q和r
 */
public class A1_3_41 {
    public static void main(String[] args) {
        Queue341<Integer> q = new Queue341<>();
        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(1);
        q.dequeue();
        Queue341<Integer> r = new Queue341<>(q);
        r.dequeue();
        System.out.println("r : ");
        while (r.first != null) {
            System.out.print(r.first.item + " ");
            r.first = r.first.next;
        }
        System.out.println();
        System.out.println("q : ");
        while (q.first != null) {
            System.out.print(q.first.item + " ");
            q.first = q.first.next;
        }
    }
}

class Queue341<Item> implements Iterable<Item> {
    Queue341() {

    }

    Queue341(Queue341 oldQueue) {
        for (Object i : oldQueue) {
            Node oldlast = last;
            last = new Node();
            last.item = (Item) i;
            last.next = null;
            if (isEmpty()) {
                first = last;
            } else oldlast.next = last;
            N++;
        }
    }

    class Node {
        Item item;
        Node next;
    }
    int N = 0;
    Node first;
    Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public void dequeue() {
        first = first.next;
        if (isEmpty()) last = null;
        N--;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
