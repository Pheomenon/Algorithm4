import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-13 22:55
 */
public class QuickFind {
    private int[] id;   // 分量id（以触点作为索引）
    private int count;  // 分量数量
    public QuickFind(int N){
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
        return id[p];
    }
    public void union(int p,int q){
        //将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if(pID == qID)  return;

        //将p的分量重命名为q的名称
        for(int i = 0; i < id.length; i++)
            if(id[i] == pID) id[i] = qID;
            count--;                                //每连进去一个点，连通分量将少一
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();                    //读取触点数量
        QuickFind uf = new QuickFind(N);              //初始化N个分量
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
