/**
 * @Author:Gao
 * @Date:2019-08-15 14:56
 */
/*
双调查找。如果一个数组中的所有元素是先递增后递减的，则称这个数组为双调的。
编写一个程序，给定一个含有N个不同int值的双调数组，判断它是否含有给定的整数
程序在最坏情况下所需测比较次数为~3lgN
 */
public class A1_4_20 {
    public static void main(String[] args) {
        int[] arr = {1,6,17,22,34,37,46,50,52,61,92,101,93,60,10,9,8,7,4,2};
        BitonicSearch binarySearch = new BitonicSearch();
        System.out.println(binarySearch.find(arr,1));
        System.out.println(arr[binarySearch.find(arr,1)]);
    }
}
class BitonicSearch{
    public int partialMaximum(int[] test){
        int N = (test.length-1)/2;
        do{
            if(test[N] > test[N+1] && test[N] > test[N-1]){
                return N;
            }
            else if(test[N+1]>test[N-1]){
                N++;
            }
            else if(test[N+1]<test[N-1]){
                N--;
            }
        }while (N!=0&&N!=test.length-1);
        return -1;
    }
    public int find(int[] arr,int key){
        int Max = partialMaximum(arr);
        if(key>Max) return -1;
        else if(key == Max) return Max;
        int length = arr.length-1;
        int toRight = Max + 1,toLeft = Max - 1;
        do{
            if(arr[toLeft] == key) return toLeft;
            else if(arr[toRight] == key) return toRight;
            else {
                if(toLeft != 0) toLeft--;
                if(toRight != length) toRight++;
            }
        }while (toLeft>=0 || toRight<=length);
        return -1;
    }
}
