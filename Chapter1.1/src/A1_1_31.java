import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author:Gao
 * @Date:2019-08-04 21:25
 */
/*
编写一段程序，从命令行接受一个整数N到double值p（0到1之间）作为参数，
在一个圆上画出大小为0.05且间距相等的N个点，然后将每对点按照概率p用灰线连接
 */
public class A1_1_31 {
    private static double tempI=0,tempJ=0.5;//记录上一个点的位置
    public static void main(String[] args) {
        double X,Y,Rradius; //Rradius为该点到圆心的距离
        double random = 0.5,r;
        StdDraw.circle(0.5,0.5,0.5);
        for (double i = 0; i < 1 ; i+=0.02){
            for (double j = 0; j < 1 ; j+=0.02) {
                if(i<=0.5&&j<0.5){
                   X=0.5-i;
                   Y=0.5-j;
                   Rradius = Math.sqrt(Math.pow(X,2)+Math.pow(Y,2));
                   if(Rradius<0.5){
                       StdDraw.point(i,j);
                       r=Math.random();
                       if(r<random){
                           StdDraw.line(tempI,tempJ,i,j);
                       }
                       tempI = i;
                       tempJ = j;
                   }
                }
                   else if(i<=0.5&&j>=0.5){
                       X=0.5-i;
                       Y=j-0.5;
                       Rradius = Math.sqrt(Math.pow(X,2)+Math.pow(Y,2));
                       if(Rradius<0.5){
                           StdDraw.point(i,j);
                           r=Math.random();
                           if(r<random){
                               StdDraw.line(tempI,tempJ,i,j);
                           }
                           tempI = i;
                           tempJ = j;
                       }
                   }
                   else if(i>0.5&&j>0.5){
                       X=i-0.5;
                       Y=j-0.5;
                       Rradius = Math.sqrt(Math.pow(X,2)+Math.pow(Y,2));
                       if(Rradius<0.5){
                           StdDraw.point(i,j);
                           r=Math.random();
                           if(r<random){
                               StdDraw.line(tempI,tempJ,i,j);
                           }
                           tempI = i;
                           tempJ = j;
                       }
                   }
                   else if(i>0.5&&j<=0.5){
                       X=i-0.5;
                       Y=0.5-j;
                       Rradius = Math.sqrt(Math.pow(X,2)+Math.pow(Y,2));
                       if(Rradius<0.5){
                           StdDraw.point(i,j);
                           r=Math.random();
                           if(r<random){
                               StdDraw.line(tempI,tempJ,i,j);
                           }
                           tempI = i;
                           tempJ = j;
                       }
                   }
                   else if(i==0.5&&j==0.5){
                       StdDraw.point(i,j);
                        }
                    }
                }
            }
        }
