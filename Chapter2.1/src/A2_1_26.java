import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @Author:Gao
 * @Date:2019-08-20 09:34
 */
/*
原始数据类型。编写一个能够处理int值的插入排序的新版本，比较它和正文中所给出的实现
(能够隐式地使用自动装箱和拆箱转换Integer值并排序)的性能.
结论：性能差距接近一倍
 */
public class A2_1_26 {
    public static void main(String[] args) {
        int[] array0 = new int[1000];
        for (int i = 0; i < array0.length; i++) {
            array0[i] = StdRandom.uniform(1000);
        }
        Stopwatch stopwatch0 = new Stopwatch();
        sort(array0);
        double time0 = stopwatch0.elapsedTime();

        Comparable[] array1 = new Comparable[1000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = StdRandom.uniform(1000);
        }
        Stopwatch stopwatch1 = new Stopwatch();
        Insertion.sort(array1);
        double time1 = stopwatch1.elapsedTime();

        System.out.println("Time0: " + time0);
        System.out.println("Time1: " + time1);
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }
}
