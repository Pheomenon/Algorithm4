import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-12 19:21
 */
public class DoublingTest {
    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = A1_4_15.TwoSumFast(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        for(int N = 250; true; N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }
}
