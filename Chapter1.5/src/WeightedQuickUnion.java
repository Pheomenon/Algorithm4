import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-15 19:22
 */
public class WeightedQuickUnion {
    private int[] id;   // 分量id（以触点作为索引）
    private int[] sz;   //（由触点索引的）各个根节点对应的分量大小
    private int count;  // 连通分量数量
    public WeightedQuickUnion(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
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
        //将p和q的根节点统一
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        //将小树的根节点链接到大树的根节点
        if(sz[i]<sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();                    //读取触点数量
        WeightedQuickUnion uf = new WeightedQuickUnion(N);              //初始化N个分量
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();                //读取整数对
            if(uf.connected(p,q))   continue;       //如果已经连通则忽略
            uf.union(p,q);                          //归并分量
            StdOut.println(p +" "+q);               //打印连接
        }
        StdOut.println(uf.count()+" components");
    }
}
