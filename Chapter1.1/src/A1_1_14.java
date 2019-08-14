/**
 * @Author:Gao
 * @Date:2019-08-03 16:10
 */
/*
编写一个静态方法lg()，接受一个整型参数N,返回不大于log2N的最大整数，不使用math库
 */
public class A1_1_14 {
    public static void main(String[] args) {
        System.out.println(lg(2047));
    }
    static int lg(int N){
        int i;
        int result = N;
        for(i=1;i<result;i++){
            N/=2;
            if(N<=1) break;
        }
        return i;
    }
}
