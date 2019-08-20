import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-20 10:27
 */
/*
希尔排序的递增序列。通过实验比较算法2.3中所使用的递增序列和递增序列1,5,19,41,109，
209,505,929,2161,3905,8929,16001,36289,64729,146305,260609
(这是通过序列9x4^k-9x2^k+1和4^k-3x2^k+1综合得到的)
 */
public class A2_1_29 {
    public static void main(String[] args) {
        SortCompare129 sortCompare129 = new SortCompare129();
        sortCompare129.alg1 = "EnhancedShell";
        sortCompare129.alg2 = "Shell";
        sortCompare129.N = 100000;
        sortCompare129.T = 100;
        sortCompare129.start();
    }
}

class EnhancedShell {
    public static void sort(Comparable[] a) {
        //将a按升序排列
        int N = a.length;
        int[] SN = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
        int h;
        for (int hIndex = SN.length - 1; hIndex > 0; hIndex--) {
            h = SN[hIndex];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

class SortCompare129 {
    String alg1;
    String alg2;
    int N;
    int T;

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("EnhancedShell")) EnhancedShell.sort(a);
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
