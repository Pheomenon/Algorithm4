import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 13:47
 */
/*
为4-sum设计一个算法
 */
public class A1_4_14 {
    public static void main(String[] args) {
        int[] a = {-1,-2,-10,-3,-6,0,3,4,2,6,8,9,10,7};
        System.out.println(FourSum.count(a));
    }
}
class FourSum{
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int t = BinarySearch.rank(-(a[i]+a[j]+a[k]),a);
                    if(t>k)
                       {
                           System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[t]);
                           cnt++;
                       }
                }
            }
        }
        return cnt;
    }
}
