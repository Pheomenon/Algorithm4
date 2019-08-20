import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-20 10:15
 */
/*
相等的主键。对于主键仅可能取两种值的数组，评估和验证插入排序和选择排序的性能，
假设两种主键值出现的概率相同
 */
public class A2_1_28 {
    public static void main(String[] args) {
        SortCompare128 sortCompare128 = new SortCompare128();
        sortCompare128.N = 1000;
        sortCompare128.T = 100;
        sortCompare128.alg1 = "Selection";
        sortCompare128.alg2 = "Insertion";
        sortCompare128.start();
    }
}

class SortCompare128 {
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
                a[i] = Double.valueOf(StdRandom.uniform(0, 2));
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
