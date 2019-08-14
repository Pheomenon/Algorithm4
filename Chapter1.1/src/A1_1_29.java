import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-03 23:22
 */
/*
为BinarySearch类添加一个静态方法rank(),它接受一个键和一个整型有序数组（可以有重复元素）
作为参数并返回数组中小于该键的元素数量，以及一个类似的方法count()来返回数组中等于该键的
元素数量。
注意：如果i和j分别是rank(key,a)和count(key,a)的返回值，那么a[i...i+j-1]就是数组中
所有和key相等的元素
 */
public class A1_1_29 {
    public static void main(String[] args) {
        int key = 12;
        int[] a = {1,2,4,5,6,7,7,7,8,12,12,12,23,25,26,28,30,35,39,40,41,43};
        System.out.println(rank(key,a));
        System.out.println(count(key,a));
    }
    public static int rank(int key,int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            if(key<=a[i])
                break;
        }
        return i;
    }
    public static int count(int key,int[] a){
        int j,count=0;
        for (j = 0; j < a.length; j++) {
            if(key==a[j])
                count++;
        }
        return count;
    }
}
