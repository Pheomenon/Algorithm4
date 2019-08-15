import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-15 20:10
 */
/*
使用quick-union算法，完成练习1.5.1.另外对处理完输入的没对整数
之后画出id[]数组表示的森林
 */
public class A1_5_2 {
    public static void main(String[] args) {
        int N = 10;
        int[] sequence = {9,0,3,4,5,8,7,2,2,1,5,7,0,3,4,2};
        QuickUnion152 uf = new QuickUnion152(N);
        for (int i = 0; i < sequence.length; i+=2) {
            if(uf.connected(sequence[i],sequence[i+1]));
            else {
                uf.union(sequence[i],sequence[i+1]);
            }
        }
        StdOut.println(uf.count()+" components");
    }
}
class QuickUnion152{
    private int[] id;   // 分量id（以触点作为索引）
    private int count;  // 分量数量
    public QuickUnion152(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    public int count()  {return count;}
    public boolean connected(int p,int q)  {return find(p) == find(q);}
    public int find(int p){
        //找出分量的名称
        while ( p != id[p]) p = id[p];
        return p;
    }
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        else {
            id[pRoot] = qRoot;
            count--;
        }
    }
}
