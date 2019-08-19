import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * @Author:Gao
 * @Date:2019-08-19 14:41
 */
/*
动画。修改插入排序和选择排序的代码，使之将数组内容绘制成正文中所示的棒状图。
在一轮排序后重绘图片来产生动画效果，并以一张“有序”的图片作为结束，
即所有的圆棒均已按照高度有序排列。提示：使用类似正文中的用例来随机生成Double值
在排序代码的适当位置调用show()方法，并在show()方法中清理画布并绘制棒状图
 */
public class A2_1_17 {
    public static void main(String[] args) throws InterruptedException {
        int size = 100;
        Double[] array = new Double[size];
        for (int i = 0; i < size; i++) {
            array[i] = StdRandom.uniform();
        }
        Insertion217.sort(array);
        Selection217.sort(array);
    }
}

class Insertion217 {
    public static void sort(Double[] a) throws InterruptedException {
        for (int i = 0; i < a.length; i++) {
            StdDraw.setXscale(-1, 100);
            StdDraw.rectangle(i, a[i] / 2, 0.5, a[i] / 2);
        }
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledRectangle(i, a[i] / 2, 0.5, a[i] / 2);
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                StdDraw.setPenColor(Color.blue);
                StdDraw.filledRectangle(j - 1, a[j] / 2, 0.5, a[j] / 2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            show(a);
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

    private static void show(Double[] a) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.rectangle(i, a[i] / 2, 0.5, a[i] / 2);
        }
        //在单行打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
//    public static void main(String[] args){
//        //从标准输入读取字符串，将它们排序并输出
//        String[] a = In.readStrings();
//        sort(a);
//        assert isSorted(a);
//        show(a);
//    }
}

class Selection217 {
    public static void sort(Double[] a) {
        for (int i = 0; i < a.length; i++) {
            StdDraw.setXscale(-1, 100);
            StdDraw.rectangle(i, a[i] / 2, 0.5, a[i] / 2);
        }
        //将a按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledRectangle(i, a[i] / 2, 0.5, a[i] / 2);
            //将a[i]和a[i+1..N]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                StdDraw.setPenColor(Color.blue);
                StdDraw.filledRectangle(j, a[j] / 2, 0.5, a[j] / 2);
            }
            exch(a, i, min);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            show(a);
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

    private static void show(Double[] a) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.rectangle(i, a[i] / 2, 0.5, a[i] / 2);
        }
        //在单行打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
