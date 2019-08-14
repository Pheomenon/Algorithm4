/**
 * @Author:Gao
 * @Date:2019-08-13 11:11
 */
/*
编写一个程序，有序打印给定的两个有序数组（含有N个int值）中所有的公共元素，
程序在最坏情况下所需的运行时间应该和N成正比
 */
public class A1_4_12 {
    public static void main(String[] args) {
        boolean flag = false;
        int[] arrA = {0,1,1,1,1,2,2,2,2,2,3,3,3,3,4,5,6,7,8,8,8,9};
        int[] arrB = {0,1,4,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,10};
        int ai=0,bi=0;
        int len=arrA.length+arrB.length;     //最坏情况每个元素至少参与一次比较
        for(int i=0;i<len;i++)
        {
            if(arrA[ai]>arrB[bi])
            {
                bi++;
                if(bi==arrB.length)  //避免数组溢出
                    break;
            }
            else if(arrA[ai]<arrB[bi])
            {
                ai++;
                if(ai==arrA.length)  //避免数组溢出
                    break;
            }
            else
            {
                StdOut.printf("%d  ", arrA[ai]);
                ai++;bi++;
                if(ai==arrA.length||bi==arrB.length)  //避免数组溢出
                    break;
            }
        }
    }
}
