import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-18 07:48
 */
/*
两个栈实现的队列。用两个栈实现一个队列，使得每个队列操作所需的堆栈操作均摊后为一个常数。
提示：如果将所有的元素压入栈中再弹出，它的顺序就被颠倒了。如果再次重复这个过程，它们
的顺序则会复原。
 */
public class A1_4_27 {
    public static void main(String[] args) {
        Queue427<Integer> stack0 = new Queue427<>();
        Queue427<Integer> queue = new Queue427<>();
        stack0.enqueue(1);
        stack0.enqueue(2);
        stack0.enqueue(3);
        queue.enqueue(stack0.dequeue());
        queue.enqueue(stack0.dequeue());
        queue.enqueue(stack0.dequeue());
        for (Object i : queue) {
            System.out.print(i + " ");
        }
    }
}

class Queue427<Item> implements Iterable<Item> {
    public class Node {
        Item item;
        Node next;
    }

    Node first;
    int N = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

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
