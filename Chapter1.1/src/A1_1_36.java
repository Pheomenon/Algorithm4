/**
 * @Author:Gao
 * @Date:2019-08-05 19:08
 */
/*
编写一个程序ShuffleTest，接受命令行参数M和N，将大小为M的数组打乱N次
且在打乱之前都将数组重新初始化为a[i]=i。打印一个MxM的表格，对于所有的列j，
行i表示的是i在打乱后落到j的位置的次数。数组中的所有元素的值应该接近于N/M
 */
public class A1_1_36 {
    public static void main(String[] args) {
        new A1_1_36().ShuffleTest(StdIn.readInt(), StdIn.readInt());
    }

    static void ShuffleTest(int N,int M){
        int[] a = new int[M];
        int[][] b = new int[M][M];
        for (int i = 0; i < N; i++) {
            for (int h = 0; h < M; h++) {
                a[h] = h;
            }
            StdRandom.shuffle(a);
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    if (j == a[k])
                        b[j][k]++;
                }
            }
        }
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++) {
                StdOut.print(b[i][j] + " ");
                if (j == M - 1)
                    StdOut.println();
            }
    }

}
