import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-03 23:02
 */
/*
给出使用欧几里得算法计算105和24的最大公约数的过程中得到的一系列p和q的值。扩展该
算法中的代码得到一个程序Euclid，从命令行接受两个参数，计算他们的最大公约数并打印
出每次调用递归方法时的两个参数。使用你的程序计算1111111和1234567的最大公约数
 */
public class A1_1_24 {
    public static void main(String[] args) {
        int m = StdIn.readInt();
        int n = StdIn.readInt();
        StdOut.printf("%d",Euclid(m,n));
    }
    static int Euclid(int m,int n){
        int r =m%n;
        if(r==0)
            return n;
        else {
            m=n;
            n=r;
            StdOut.printf("%d,%d\n",m,n);
            return Euclid(m,n);
        }
    }
}
