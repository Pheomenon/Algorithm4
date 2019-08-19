import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-19 08:47
 */
/*
生日问题。编写一个程序，从命令行接受一个整数N作为参数并使用StdRandom.uniform()生成
一系列0到N-1之间的随机整数。通过实验验证产生第一个重复的随机整数之前生成的整数
数量为~sqrt(PI*N/2)
 */
public class A1_4_44 {
    public static void main(String[] args) {
        int N = 10000;
        int tries = 0;
        int avg = 0;
        int[] test = new int[N];
        for (int j = 0; j < 10000; j++) {
            Arrays.fill(test, 0);
            test[0] = -1;
            for (int i = 0; i < N * 10; i++) {
                int temp = StdRandom.uniform(N - 1);
                tries++;
                if (temp != test[temp]) test[temp] = temp;
                else {
                    System.out.println(tries);
                    StdDraw.setYscale(-3 * Math.sqrt(Math.PI * N / 2), 4 * Math.sqrt(Math.PI * N / 2));
                    StdDraw.setXscale(0, 10000);
                    StdDraw.setPenRadius(.005);
                    StdDraw.point(j, tries);
                    avg += tries;
                    tries = 0;
                    break;
                }
            }
        }
        avg /= 10000;
        System.out.println("AVG: " + avg);

    }
}
