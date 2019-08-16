/**
 * @Author:Gao
 * @Date:2019-08-16 10:57
 */
/*
删除第k个元素。实现一个类并支持一下API
泛型一般队列的API
public class GeneralizedQueue<Item>
             GeneralizedQueue()         创建一个空队列
     boolean isEmpty()                  队列是否为空
        void insert(Item x)             添加一个元素
        Item delete(int k)              删除并返回最早插入的第k个元素
 首先用数组实现该数据类型，然后用链表实现该数据类型
 注意：在第三章中介绍的算法和数据结构可以保证insert()和delete()的实现所需的运行时间和队列中的元素数量成对数关系
 */
public class A1_3_38 {
    public static void main(String[] args) {
        GeneralizedQueueArray<Integer> queueArray = new GeneralizedQueueArray<>();
        queueArray.insert(0);
        queueArray.insert(1);
        System.out.print(queueArray.delete() + " ");
        System.out.print(queueArray.delete() + " ");
        queueArray.insert(3);
        System.out.println(queueArray.delete());
        GeneralizedQueueLinkList<Integer> queueLinkList = new GeneralizedQueueLinkList<>();
        queueLinkList.insert(0);
        queueLinkList.insert(1);
        System.out.print(queueLinkList.delete() + " ");
        System.out.print(queueLinkList.delete() + " ");
        queueLinkList.insert(3);
        System.out.println(queueLinkList.delete());
    }
}

class GeneralizedQueueArray<Item> {
    private Item[] items = (Item[]) new Object[1];
    int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void insert(Item x) {
        if (N == items.length) resize(2 * items.length);
        items[N++] = x;
    }

    public Item delete() {
        if (N > 0 && N == items.length / 4) resize(items.length / 2);
        Item target = items[0];
        for (int i = 0; i < N - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--N] = null;
        return target;
    }
}

class GeneralizedQueueLinkList<Item> {
    public class Node {
        Item item;
        Node next;
    }

    int N = 0;
    Node first;

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item delete() {
        Node last;
        Node current = first;
        for (int i = 0; i < N - 1; i++) {
            current = current.next;
        }
        last = current;
        Item target = last.item;
        N--;
        return target;
    }
}