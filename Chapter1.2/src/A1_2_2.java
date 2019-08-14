import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-09 10:01
 */
/*
编写一个Interval1D用例。接受一个整数N。读取N个间隔（每个间隔由double定义）。并打印出所有相交的间隔对
 */
public class A1_2_2 {
    public static void main(String[] args) {
       int N = StdIn.readInt();
        Interval1D[] interval1DS = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            interval1DS[i] = new Interval1D(StdIn.readDouble(),StdIn.readDouble());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N-1; j++) {
                if(interval1DS[i].intersects(interval1DS[j + 1])){
                    StdOut.println(interval1DS[i].toString()+" "+interval1DS[j+1].toString());
                }
            }
        }
    }
}
