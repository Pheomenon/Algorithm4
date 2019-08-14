import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-08 21:39
 */
/*
编写一个Point2D用例，从命令行接受一个整数N。在单位正方形中生成N个随机点，然后计算两点之间的最近距离
 */
public class A1_2_1 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        double[][] pointPosition = new double[N][2];
        double[][] pointDistance = new double[N][N];
        double disX;
        double disY;
        double min,minX0=0,minY0=0,minX1=0,minY1=0;
        double max,maxX0=0,maxY0=0,maxX1=0,maxY1=0;
        double x,y;
        for (int i = 0; i < N; i++) {
            x = StdRandom.random();
            y = StdRandom.random();
            pointPosition[i][0] = x;
            pointPosition[i][1] = y;
            StdDraw.point(x,y);
        }

        min = 1;
        max = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1; j++) {
                disX = pointPosition[i][0] - pointPosition[j+1][0];
                disY = pointPosition[i][1] - pointPosition[j+1][1];
                pointDistance[i][j+1] = Math.sqrt(Math.pow(disX,2) + Math.pow(disY,2));
            }

        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(pointDistance[i][j]<min && pointDistance[i][j]!=0)
                {
                    min = pointDistance[i][j];
                    minX0 = pointPosition[i][0];
                    minY0 = pointPosition[i][1];
                    minX1 = pointPosition[j][0];
                    minY1 = pointPosition[j][1];
                }
                if(pointDistance[i][j]>max)
                {
                    max = pointDistance[i][j];
                    maxX0 = pointPosition[i][0];
                    maxY0 = pointPosition[i][1];
                    maxX1 = pointPosition[j][0];
                    maxY1 = pointPosition[j][1];
                }
            }
        }
        System.out.println(minX0+" "+minY0+" "+minX1+" "+minY1+" ");
        System.out.println(maxX0+" "+maxY0+" "+maxX1+" "+maxY1+" ");
        System.out.println("MIN: "+min);
        System.out.println("MAX: "+max);
        StdDraw.line(minX0,minY0,minX1,minY1);
        StdDraw.line(maxX0,maxY0,maxX1,maxY1);
    }
}
