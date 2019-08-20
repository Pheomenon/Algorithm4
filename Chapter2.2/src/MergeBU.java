/**
 * @Author:Gao
 * @Date:2019-08-20 14:08
 */
public class MergeBU {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)   //将a[lo..hi]复制到aux[lo,,hi]
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)   //归并回到a[lo..hi]
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) {
        //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }
}
