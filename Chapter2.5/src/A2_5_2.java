import edu.princeton.cs.algs4.StdIn;

/**
 * @Author:Gao
 * @Date:2019-08-23 08:34
 */
/*
编写一段程序，从标准输入读入一列带刺并打印出其中所有由两个单词组成的组合词。
例如，加入输入的单词为after，through和afterthought，那么afterthought就是一个组合词
 */
public class A2_5_2 {
    public static void main(String[] args) {
        Queue52 queue = new Queue52();
        do {
            String Str = StdIn.readString();
            if (Str.equals("quit")) break;
            else queue.enqueue(Str);
        } while (!StdIn.isEmpty());
        for (int i = 0; i < queue.N; i++) {
            queue.compareTo();
        }
    }
}

class Queue52 {
    public class Node {
        String item;
        Node next;
    }

    Node first, last;
    int N = 0;

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public void compareTo() {
        int queueLength = N;
        Node currentFirst = first;
        Node currentNext = first.next;
        int count = 0;
        for (int i = 0; i < currentFirst.item.length(); i++) {
            for (int j = 2; j < N; j++) {
                if (currentFirst.item.charAt(i) == currentNext.item.charAt(i))
                    count++;
                else {
                    queueLength--;
                }
                if (queueLength > 0) {
                    currentNext = currentNext.next;
                }
                if (count == currentFirst.item.length()) {
                    System.out.println(currentFirst);
                }
            }
            if (!isEmpty())
                currentFirst = currentFirst.next;
            else break;
        }
    }
}
