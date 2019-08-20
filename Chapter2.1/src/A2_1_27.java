import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-20 09:50
 */
/*
希尔排序的用时是次平方级的。在你的计算机上用SortCompare比较希尔排序和插入排序以及选择排序
测试数组的大小按照2的幂次递增，从128开始
 */
public class A2_1_27 {
    public static void main(String[] args) {
        SortCompare127 sortCompare127 = new SortCompare127();
        for (int i = 128; i < Math.pow(2, 20); i *= 2) {
            sortCompare127.N = i;
            sortCompare127.T = 10;
            sortCompare127.alg1 = "Shell";
            sortCompare127.alg2 = "Insertion";
            sortCompare127.start();
        }
    }
}

class SortCompare127 {
    String alg1;
    String alg2;
    int N;
    int T;

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Insertion124")) Insertion124.sort(a);
        if (alg.equals("Insertion125")) Insertion125.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Insertion.sort(a);
        if (alg.equals("Quick")) Insertion.sort(a);
        if (alg.equals("Heap")) Insertion.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        //使用算法1将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            //进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public void start() {
        double t1 = timeRandomInput(alg1, N, T); //算法1的总时间
        double t2 = timeRandomInput(alg2, N, T); //算法2的总时间
        StdOut.printf("For %d random Doubles\n   %s is ", N, alg1);
        StdOut.printf("%.1f times faster than %s\n", t2 / t1, alg2);
    }
}