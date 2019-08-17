import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-17 10:30
 */
/*
复制栈。为基于链表实现的栈编写一个新的构造函数，使以下代码
Stack<Item> t = new Stack<Item>(s);
得到t指向栈s的一个新的独立的副本
 */
public class A1_3_42 {
    public static void main(String[] args) {
        Stack342<Integer> s = new Stack342<>();
        s.push(1);
        s.push(2);
        s.push(3);
        Stack342<Integer> t = new Stack342<>(s);
        t.push(4);
        s.push(9);
        System.out.println("s:");
        while (s.first != null) {
            System.out.print(s.first.item + " ");
            s.first = s.first.next;
        }
        System.out.println("\nt:");
        while (t.first != null) {
            System.out.print(t.first.item + " ");
            t.first = t.first.next;
        }
    }
}

class Stack342<Item> implements Iterable<Item> {
    public class Node {
        Item item;
        Node next;
    }

    int N = 0;
    Node first;
    Node last;

    Stack342() {
    }

    Stack342(Stack342 oldStack) {
        for (Object i : oldStack) {
            Node oldLast = last;
            last = new Node();
            last.item = (Item) i;
            if (isEmpty()) first = last;
            else oldLast.next = last;
            N++;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        N++;
    }

    public void pop() {
        first = first.next;
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
