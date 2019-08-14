/**
 * @Author:Gao
 * @Date:2019-08-03 16:35
 */
/*
编写一个静态方法histogram(),接受一个整型数组a[]和一个整数M为参数
并返回一个大小为M的数组，其中第i个元素的值为整数i在参数数组中出现的
次数，如果a[]中的值均在0到M-1之间，返回数组中所有元素之和应该和a.length相等
 */
public class A1_1_15 {
    public static void main(String[] args) {
        int[] a = {1,2,2,2,3,3,4,4,4,4,5,6,6,6,7,7,7,8,9,9,10};
        int M = 3;
        int[] result = new int[M];
        result = histogram(a,M);
        for (int i : result) {
            System.out.println(i);
        }

    }
    static int[] histogram(int[] a,int M ){
        int[] result = new int[20];
        int num,temp;
        for(int i=0;i<a.length;i++){
            num = a[i];
            temp = result[num];
            temp++;
            result[num] = temp;
        }
        int[] fin_result = new int [M];
        for(int i=0;i<M;i++){
            fin_result[i]=result[i];
        }
        return fin_result;
    }
}
