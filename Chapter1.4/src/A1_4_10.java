import com.sun.deploy.security.SelectableSecurityManager;

/**
 * @Author:Gao
 * @Date:2019-08-12 21:50
 */
/*
修改二分查找算法，使之总是返回和被查找的键匹配的索引最小的元素
 */
public class A1_4_10 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,4,4,4,9};
        System.out.println(rank(a,9));
    }
    private static int rank(int[] a, int key){
        int lo=0,hi=a.length-1;
        int temp;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            temp = mid;
            if(a[mid]==key) {
                while (mid != 0 && a[--mid] == key)
                    temp = mid;
                return temp;
            }
            else if(a[mid]>key){
                hi = mid-1;
            }
            else if(a[mid]<key){
                lo = mid+1;
            }
        }
        return -1;
    }
}
