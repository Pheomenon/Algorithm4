import java.io.File;

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
        Queue341<Integer> r = new Queue341<>(q);
        r.dequeue();
        r.enqueue(9);
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

class Queue341<Item> {
    Queue341() {

    }

    Queue341(Queue341 oldQueue) {
        Queue341 newQueue = new Queue341();
        newQueue.N = oldQueue.N;
        Node current = oldQueue.first;
        for (int i = 0; i < newQueue.N; i++) {
            Node oldfirst = newQueue.first;
            newQueue.first = new Node();
            newQueue.first.item = current.item;
            if (N == 0) {
                newQueue.first.next = null;
                N++;
            } else oldfirst.next = newQueue.first;
            current = current.next;
        }
        first = newQueue.first;
//        Node current = first;
//        boolean flag = false;
//        while (current != null){
//            if(!flag){
//                First = new Node();
//                First.item = current.item;
//                current = current.next;
//                flag = true;
//            }
//            Node oldFirst = First;
//            First = new Node();
//            First.item = current.item;
//            First.next = oldFirst;
//        }
    }

    class Node {
        Item item;
        Node next;
    }

    int N = 0;
    Node first;

    //    Node First;
    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public void dequeue() {
        first = first.next;
        N--;
    }
}
