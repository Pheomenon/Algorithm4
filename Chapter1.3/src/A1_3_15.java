import edu.princeton.cs.algs4.StdIn;

/**
 * @Author:Gao
 * @Date:2019-08-10 16:38
 */
/*
编写一个Queue的用例，接受一个命令行参数k
并打印出标准输入中的倒数第k个字符串
 */
public class A1_3_15 {
    public static void main(String[] args) {
        int count = 0;
        Queue<String> queue = new Queue<>();
        queue.enqueue("to");
        queue.enqueue("be");
        queue.enqueue("or");
        queue.enqueue("not");
        queue.enqueue("be");
        queue.enqueue("this");
        queue.enqueue("is");
        queue.enqueue("a");
        queue.enqueue("question");
        int k = StdIn.readInt();
        count = queue.size();
        for (int i = 0; i <= count-k-1; i++) {
            queue.dequeue();
            if(i==count-k-1) {
                System.out.println(queue.dequeue());
                break;
            }
        }
    }
}
