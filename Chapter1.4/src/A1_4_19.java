
/**
 * @Author:Gao
 * @Date:2019-08-14 21:11
 */
/*
矩阵的局部最小元素。给定一个含有N^2个不同整数的NxN数组a[]。设计一个运行时间和N
成正比的算法来找出一个局部最小元素：满足a[i][j]<a[i+1][j],a[i][j]<a[i][j+1],
a[i][j]<a[i-1][j]以及a[i][j]<a[i][j-1]的索引i和j。程序的运行时间在最坏的情况下
应该和N成正比
 */
public class A1_4_19 {
    public static void main(String[] args) {
        int[][] matrix = {
                {90,543,156,85,384,76,98,54,343,26},
                {35,543,284,21,45,987,4,765,341,87},
                {16,543,456,354,358,30,324,146,43,35},
                {54,543,354,12,20,654,354,34,65,76},
                {354,432,687,756,154,95,98,42,43,951},
                {241,36,354,981,63,76,98,1,20,465},
                {321,543,63,215,957,35,98,59,91,952},
                {897,354,210,45,512,24,35,34,54,22},
                {654,351,358,985,456,28,94,17,28,88},
                {58,388,355,354,37,76,98,458,243,91}
        };
        PartialMinimumElement partialMinimumElement = new PartialMinimumElement();
        partialMinimumElement.find(matrix);
        int x = partialMinimumElement.getX();
        int y = partialMinimumElement.getY();
        System.out.println(x+" "+y);
    }
}
class PartialMinimumElement{
    private int x,y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void find(int[][] matrix){
        int length = matrix.length/2;
        x = length;
        y = length;
        do{
            if(matrix[x][y]<matrix[x+1][y]&&
               matrix[x][y]<matrix[x][y+1]&&
               matrix[x][y]<matrix[x-1][y]&&
               matrix[x][y]<matrix[x][y-1]){
               break;
            }
            else {
                int[] temp = new int[4];
                temp[0] = matrix[x+1][y];
                temp[1] = matrix[x][y+1];
                temp[2] = matrix[x-1][y];
                temp[3] = matrix[x][y-1];
                if(temp[0]<temp[1]&&temp[0]<temp[2]&&temp[0]<temp[3]){
                    x=x+1;
                }
                else if(temp[1]<temp[0]&&temp[1]<temp[2]&&temp[1]<temp[3]){
                    y=y+1;
                }
                else if(temp[2]<temp[0]&&temp[2]<temp[1]&&temp[2]<temp[3]){
                    x=x-1;
                }
                else if(temp[3]<temp[0]&&temp[3]<temp[1]&&temp[3]<temp[2]){
                    y=y-1;
                }
            }
        }while (x!=0||x!=length||y!=0||y!=length);
    }
}
