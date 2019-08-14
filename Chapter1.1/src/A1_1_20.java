/**
 * @Author:Gao
 * @Date:2019-08-03 20:40
 */
/*
编写一个递归的静态方法计算lg(N!)的值
 */
public class A1_1_20 {
    public static void main(String[] args) {
        System.out.println(factorial_logarithm(5));
    }
    static double factorial_logarithm(double N){
        if(N == 0 || N == 1)return 0.0;  // 0的阶乘和1的阶乘都为1
        else {
            return Math.log(N)+factorial_logarithm(N-1);
        }
    }
}
