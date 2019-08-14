import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-12 19:20
 */
/*
修改DoublingTest，使用StdDraw产生类似于正文中的标准图像和对数图像，
根据需要调整比例使图像总能充满窗口的大部分区域
 */
public class A1_4_3 {
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        StdDraw.setYscale(0,50);
        StdDraw.setXscale(0,9000);
        StdDraw.setPenRadius(.01);
        for(int N = 1; N < 10000; N+=100){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
            StdDraw.point(N,time);
        }
    }
}

