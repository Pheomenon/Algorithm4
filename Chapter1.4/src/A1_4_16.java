import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 15:59
 */
/*
最接近的一对（一维）。编写一个程序，[],在其中找到
一对最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需分运行时间应该是线性对数级别的
 */
public class A1_4_16 {
    public static void main(String[] args) {
        double[] a = {-11.2,-3.1,-9.54,-6,1.8,-1,2.4,2.2};
        Arrays.sort(a);
        double[] result = closest(a);
        for (double v : result) {
            System.out.println(v);
        }
    }
    public static double[] closest(double[] a){
        double sub=a[a.length-1] - a[0]+1;
        double[] result = new double[2];
        for (int i = 0; i < a.length-1; i++) {
            if(sub>Math.abs(Math.abs(a[i])-Math.abs(a[i+1]))){
                sub = Math.abs(Math.abs(a[i])-Math.abs(a[i+1]));
                result[0] = a[i];
                result[1] = a[i+1];
            }
        }
        return result;
    }
}
