/**
 * @Author:Gao
 * @Date:2019-08-03 21:34
 */
/*
从标准输入按行读取数据，其中每行都包括一个名字和两个整数，然后用
printf()打印一张表格，每行的若干列数据包括名字，两个整数，和第一个整数除以
第二个整数的结果，精确到小数点后三位
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class A1_1_21 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()){
            String name = StdIn.readString();
            int age = StdIn.readInt();
            int date = StdIn.readInt();
            double k=(double)age/(double)date;
            StdOut.printf("%s ",name);
            StdOut.printf("%d ",age);
            StdOut.printf("%d ",date);
            StdOut.printf("%.3f",k);
        }
    }
}
