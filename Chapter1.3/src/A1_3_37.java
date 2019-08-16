import edu.princeton.cs.algs4.StdIn;

/**
 * @Author:Gao
 * @Date:2019-08-16 09:31
 */
/*
Josephus问题。在这个古老的问题中。N个深陷绝境的人一直通过以下方式减少生存人数。
他们围坐成一圈（位置记为0到N-1）并从第一个人开始，报到M的人会被杀死，
知道最后一个人留下来。传说Josephus找到了不会被杀死的位置。编写一个Queue的用例Josephus，
从命令行接受N和M并打印出人们被杀死的顺序（这也将显示Josephus在圈中的位置）
%java Josephus 7 2
1 3 5 0 4 2 6
 */
public class A1_3_37 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        int N = StdIn.readInt();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        int M = StdIn.readInt();
        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++)//每M个人中，去掉最后一名（即第M名），所以将前M-1个人放在队尾，删掉第M个人。
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");
        }
    }
}


