import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-20 08:36
 */
/*
插入排序的哨兵。在插入排序的实现中先找出最小的元素并将其置于数组的左边，
这样就能去掉内循环的判断条件j>0.使用SortCompare来评估这种做法的效果。
注意：这是一种常见的规避边界测试的方法，能够省略判断条件的元素通常被称为哨兵
 */
class Insertion124 {
    public static void sort(Comparable[] a) {
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[min])) min = i;
        }
        exch(a, min, 0);
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            for (int j = i; less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
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

    private static void show(Comparable[] a) {
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
