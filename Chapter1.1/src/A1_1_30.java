/**
 * @Author:Gao
 * @Date:2019-08-04 20:33
 */
/*
编写一段程序，创建一个NxN的布尔数组a[][]，其中当i和j互质时（没有相同因子），
a[i][j]为true，否则返回false
 */
public class A1_1_30 {
    public static void main(String[] args) {
        boolean[][] a = new boolean[10][10];
        prime(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println("\n");
            for (int j = 0; j <a[i].length ; j++) {
                System.out.print(i+":"+j+" "+a[i][j]+"\t");
            }
        }
    }
    static boolean[][] prime(boolean a[][]){
        for (int i = 1; i <a.length; i++) {
            for (int j = 1; j <a[i].length; j++) {
                if(A1_1_24.Euclid(i,j)!=1){
                    a[i][j] = true;
                }
            }
        }
        return a;
    }
}
