import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-15 20:21
 */
/*
使用加权quick-union算法完成练习1.5.1
 */
public class A1_5_3 {
    public static void main(String[] args) {
        int N = 10;
        int[] sequence = {9,0,3,4,5,8,7,2,2,1,5,7,0,3,4,2};
        WrightQuickUnion153 uf = new WrightQuickUnion153(N);
        for (int i = 0; i < sequence.length; i+=2) {
            if(uf.connected(sequence[i],sequence[i+1]));
            else {
                uf.union(sequence[i],sequence[i+1]);
            }
        }
        StdOut.println(uf.count()+" components");
    }
}
class WrightQuickUnion153{
    private int id[];
    private int sz[];
    private int count;

    public WrightQuickUnion153(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    public int count()  {return count;}
    public boolean connected(int p,int q)  {return find(p) == find(q);}
    public int find(int p){
        //跟随链接找到根结点
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i==j)    return;
        if(sz[i]<sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
