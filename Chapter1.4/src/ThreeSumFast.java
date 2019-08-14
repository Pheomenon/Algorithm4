import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 13:32
 */
public class ThreeSumFast {
    public static void main(String[] args) {
        int[] a = {0,0,0,1,2,3,3,3,3,3};
        System.out.println(ThreeSumFast.count(a));
    }
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int t = BinarySearch.rank(-a[i]-a[j],a);
                if(t>j)
                    cnt++;
            }
        }
        return cnt;
    }
}
