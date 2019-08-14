import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author:Gao
 * @Date:2019-08-09 10:44
 */
/*
编写一个Interval2D的用例，从命令行接受参数N,min和max，
生成N个随机的2D间隔，其宽和高均匀的分布在单位正方形中的min和max之间，
用StdDraw画出它们并打印出相交的间隔对的数量以及有包含关系的间隔对数量
 */
public class A1_2_3 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();
        drawBox(1,1);
        int count = 0;
        double intervalMin,intervalMax,temp;
        Interval1D[] xInterval1DS = new Interval1D[N];
        Interval1D[] yInterval1DS = new Interval1D[N];
        Interval2D[] Interval2DS = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            intervalMax = myRandom(min,max);
            intervalMin = myRandom(min,max);
            if(intervalMax<intervalMin){
                temp = intervalMax;
                intervalMax = intervalMin;
                intervalMin = temp;
            }
            xInterval1DS[i] = new Interval1D(intervalMin,intervalMax);
            intervalMax = myRandom(min,max);
            intervalMin = myRandom(min,max);
            if(intervalMax<intervalMin){
                temp = intervalMax;
                intervalMax = intervalMin;
                intervalMin = temp;
            }
            yInterval1DS[i] = new Interval1D(intervalMin,intervalMax);

            Interval2DS[i] = new Interval2D(xInterval1DS[i],yInterval1DS[i]);
            Interval2DS[i].draw();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(Interval2DS[i].intersects(Interval2DS[j])){
                    System.out.println(xInterval1DS[i].toString()+" "+yInterval1DS[j].toString());
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    static void drawBox(double bw,double bh){
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        Interval1D xInterval = new Interval1D(0,bw);
        Interval1D yInterval = new Interval1D(0,bh);
        Interval2D box = new Interval2D(xInterval,yInterval);
        box.draw();
    }
    static double myRandom(double min,double max){
        double myrandom;
        myrandom = StdRandom.random();
        if(myrandom>max||myrandom<min){
            return myRandom(min,max);
        }
        return myrandom;
    }
}
