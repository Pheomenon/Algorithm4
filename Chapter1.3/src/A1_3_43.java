import java.io.File;
import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-17 10:58
 */
/*
文件列表。文件夹就是一列文件和文件夹的列表。编写一个程序，
从命令行接受一个文件夹名为参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件夹的名下（缩进）
列出其下的所有文件。提示：使用队列，并参考java.io.File
 */
public class A1_3_43 {
    public static void main(String[] args) {
        Queue343<String> user = new Queue343<>();
        user.enqueue("Administrator");
        user.enqueue("AllUsers");
        user.enqueue("DefaultUser");

        Queue343<String> Administrator = new Queue343<>(user, "Administrator");
        Administrator.enqueue("Anaconda3");
        Administrator.enqueue("AppData");
        Administrator.enqueue("IntelGraphicsProfiles");
        Administrator.enqueue("debug.txt");

//        Queue343<String> AllUser = new Queue343<>(user,"AllUser");
//        Administrator.enqueue("Anaconda3");
//        Administrator.enqueue("AppData");
//        Administrator.enqueue("IntelGraphicsProfiles");
//        Administrator.enqueue("debug.txt");

        Queue343<String> Anaconda3 = new Queue343<>(Administrator, "Anaconda3");
//        Anaconda3.enqueue("python.exe");

//            for (Object i : Administrator) {
//                System.out.println(i);
//
//            } System.out.println();
//        System.out.println(user.first.item);
        user.open();
    }
}

class Queue343<Item> implements Iterable<Item> {
    Queue343() {

    }

    Queue343(Queue343 oldQueue, String foldName) {
        enqueue((Item) "Empty Folder");
        Node current = oldQueue.first;
        for (int i = 0; i < oldQueue.N; i++) {
            if (current.item == foldName)
                current.subFile = first;
        }
    }

    class Node {
        Item item;
        Node next;
        Node subFile;
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

    public void open() {
        Node current = first;
        Node fatherFold;
        for (int i = 0; i < N; i++) {
            System.out.println(current.item);
            if (current.subFile != null) {
                show(current.subFile);
//                fatherFold = current;
//                current = current.subFile;
//                while (current.item!=null){
//                    System.out.print("\t"+current.item);
//                    if(current.next != null)
//                        current = current.next;
//                    else {
//                        System.out.println();
//                        current = fatherFold;
//                        break;
//                    }
//                }
            }
            current = current.next;
        }
    }

    private void show(Node node) {
        while (node != null) {
//            if(node.subFile!=null){
//                show(node.subFile);
//            }
            System.out.print("\t" + node.item);
            if (node.next != null)
                node = node.next;
            else {
                System.out.println();
                return;
            }
        }
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
