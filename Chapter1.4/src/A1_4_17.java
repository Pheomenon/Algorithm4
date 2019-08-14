import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 17:03
 */
/*
最遥远的一对。编写一个程序，给定一个含有N个double值的数组a[]，在其中找到
一对最遥远的值：两者之差（绝对值）最大的两个数。程序在最坏的情况下运行时间应该是线性级别的
 */
public class A1_4_17 {
    public static void main(String[] args) {
        double[] a = {-11.2,-3.1,-9.54,-6,1.8,-1,2.4,2.2};
        Arrays.sort(a);
        double[] result = closest(a);
        for (int i = 0; i < result.length; i++) {
            System.out.println(a[(int)result[i]]);
        }
    }
    public static double[] closest(double[] a){
        double[] result = new double[2];
        int minIndex=0;
        int maxIndex=0;
        for(int i=0;i<a.length;i++)
            {
                if(a[i]<a[minIndex]) {
                    minIndex=i;
                    result[0] = i;
                }
                else if (a[i]>a[maxIndex]) {
                    maxIndex = i;
                    result[1] = i;
                }
            }
        return result;
    }
}
