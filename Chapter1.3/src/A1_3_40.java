/**
 * @Author:Gao
 * @Date:2019-08-16 12:32
 */
/*
前移编码。从标准输入读取一串字符，使用链表保存这些字符并清除重复字符。
当读取到了一个从未见过的字符时，将它插入表头。当读取了一个重复的字符时，
将它从链表中删去并再次插入表头。将你的程序命名为MoveToFront：它实现了著名的前移编码策略，
这种策略假设最近访问过的元素可能会再次访问，因此可以用于缓存，压缩数据等许多场景
 */
public class A1_3_40 {
    public static void main(String[] args) {
        MoveToFront moveToFront = new MoveToFront();
        moveToFront.enqueue("0dkl00pxx0");
        while (moveToFront.first != null) {
            System.out.print(moveToFront.first.item + " ");
            moveToFront.first = moveToFront.first.Tail;
        }
    }
}

class MoveToFront {
    class Node {
        char item;
        Node Head;
        Node Tail;
    }

    int N = 0;
    Node first, last;

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(String str) {
        for (int i = 0; i < str.length(); i++) {
            Node oldFirst = first;
            first = new Node();
            if (isEmpty()) {
                first.item = str.charAt(N++);
                first.Tail = null;
                first.Head = first;
                last = first;
            } else {
                first.Head = null;
                first.Tail = oldFirst;
                first.item = str.charAt(N++);
                oldFirst.Head = first;
            }

            Node current = first.Tail;
            while (current != null && N > 0) {
                if (str.charAt(N - 1) != current.item) {
                    current = current.Tail;
                } else if (str.charAt(N - 1) == current.item && current.Head == null) {
//                    N--;
                    current.Tail = current.Tail.Tail;
                    current.Tail.Head = current;
                    break;
                } else if (str.charAt(N - 1) == current.item && current.Tail == null) {
//                    N--;
                    current.Head.Tail = null;
                    break;
                } else if (str.charAt(N - 1) == current.item && current.Head != null && current.Tail != null) {
//                    N--;
                    current.Head.Tail = current.Tail;
                    current.Tail.Head = current.Head;
                    break;
                }
            }
        }
    }
}
