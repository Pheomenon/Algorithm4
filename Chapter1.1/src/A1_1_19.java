import java.math.BigInteger;

/**
 * @Author:Gao
 * @Date:2019-08-03 17:39
 */
/*
开发F(N)的一个更好的实现，用数组保存已经计算的值
 */
public class A1_1_19 {
    public static void main(String[] args){
        NewF(10);
//        for(int N = 0;N<100;N++)
//            System.out.println(N+" "+NewF(N));
    }
    public static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N-1)+F(N-2);
    }
    public static void NewF(int N){
        BigInteger front = BigInteger.valueOf(0);
        BigInteger behind = BigInteger.valueOf(1);
        System.out.println(0+" "+front);
        System.out.println(1+" "+behind);
        for(int i=2;i<N;i++){
            front = front.add(behind);
            System.out.println(i+" "+front);
            i++;
            behind = front.add(behind);
            System.out.println(i+" "+behind);
        }
    }
}
