import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 14:39
 */
/*
快速3-sum，使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）
实现TwoSumFast来计算已排序的数组中和为0的整数对的数量，
用相同的思想为3-sum问题给出一个平方级别的算法
 */
public class A1_4_15 {
    public static void main(String[] args) {
        int[] a = {-11,-3,-9,-2,-5,-8,-6,1,2,4,3,8,5,9,7,0};
        Arrays.sort(a);
        System.out.println(TwoSumFast(a));
        System.out.println(ThreeSumFast(a));
    }
    public static int TwoSumFast(int[] a){
        int cnt = 0;
        int i=0,j=0;
        int length = a.length - 1;
        while (i!=length-j&&length-j>0&&i<length-j){
            if (Math.abs(a[i]) == a[length - j]) {
                cnt++;
                i++;
                j++;
            }
            else if (Math.abs(a[i]) > a[length - j]) i++;
            else if (Math.abs(a[i]) < a[length - j]) j++;
        }
        return cnt;
    }
    public static int ThreeSumFast(int[] a){
        int cnt = 0;
        int i=0,j=1,k=0;
        int length = a.length - 1;
        while (i!=length-j&&length-j>0) {
            i++;
            j++;
            while (j!=length-k&&j!=length) {
                if (Math.abs(a[i])+Math.abs(a[j]) == a[length - k]) {
                    System.out.println(a[i]+" "+a[j]+" "+a[length-k]);
                    cnt++;
                    break;
                }
                else if (Math.abs(a[i])+Math.abs(a[j]) > a[length - k]){
                    j++;
                }
                else if (Math.abs(a[i])+Math.abs(a[j]) < a[length - k]) k++;
            }
        }
        return cnt;
    }
}
