/**
 * @Author:Gao
 * @Date:2019-08-14 20:20
 */
/*
数组的局部最小元素。编写一个程序，给定一个含有N个不同整数的数组，找到一个局部最小
元素:满足a[i]<a[i-1]且a[i]<a[i+1]的索引i。程序在最坏情况下所需的比较次数为 ~2lgN
 */
public class A1_4_18 {
    public static void main(String[] args) {
        int[] test = {1,3,6,87,100,101,54,2,8,9,90};
        int N = (test.length-1)/2;
        do{
        if(test[N] < test[N+1] && test[N] < test[N-1]){
            System.out.println(N);
            break;
        }
        else if(test[N+1]>test[N-1]){
            N--;
        }
        else if(test[N+1]<test[N-1]){
            N++;
        }
        }while (N!=0&&N!=test.length-1);
    }
}
//class PartialMinimum{
//    int min;
//    public int findMinimum(int[] arr,int position){
//        int N = arr.length-1;
//        if(arr[N/2] < arr[N/2+1] && arr[N/2] < arr[N/2-1]){
//            min = N/2;
//            return min;
//        }
//        else if(arr[N/2+1]>arr[N/2-1]){
//            return findMinimum(arr[N/2-1]);
//        }
//    }
//}