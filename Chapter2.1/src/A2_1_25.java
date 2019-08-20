/**
 * @Author:Gao
 * @Date:2019-08-20 08:53
 */
/*
不需要交换的插入排序。在插入排序的实现中使较大元素右移一位只需要访问一次数组
而不是用exch()。使用SortCompare来评估这种做法的效果
 */
class Insertion125 {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i; j > 0 && less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
