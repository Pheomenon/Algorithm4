import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-03 22:29
 */
/*
使用1.1.6.4节中的rank()递归方法重新实现BinarySearch()并跟踪该方法的调用。
每当方法被调用时，打印出他的参数lo和hi并按照递归的深度缩进。
提示：为递归方法添加一个参数来保存递归的深度
 */
public class A1_1_22 {
    public static void main(String[] args) {
        int key = 43;
        int[] a = {1,2,4,5,6,7,8,12,23,25,26,28,30,35,39,40,41,43};
        System.out.println(rank(43,a));
    }
    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length-1,0);

    }
    public static int rank(int key,int[] a,int lo,int hi,int deep){
        if(lo>hi) return -1;
        int mid = lo+(hi-lo)/2;
        if(key<a[mid]) {
            for(int i=0;i<deep;i++){
                System.out.print("\t");
            }
            StdOut.printf("%d,%d\n",lo,hi);
            return rank(key,a,lo,mid-1,++deep);
        }
        else if(key>a[mid]) {
            for (int i=0;i<deep;i++){
                System.out.print("\t");
            }
            StdOut.printf("%d,%d\n",lo,hi);
            return rank(key,a,mid+1,hi,++deep);
        }
        else return mid;
    }
}
