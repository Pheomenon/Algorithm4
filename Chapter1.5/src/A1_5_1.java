import edu.princeton.cs.algs4.StdOut;

/**
 * @Author:Gao
 * @Date:2019-08-15 19:35
 */
/*
使用quick-find算法处理序列9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2
对于输入的每一对整数，给出id[]数组的内容和访问数组的次数
 */
public class A1_5_1 {
    public static void main(String[] args) {
        int N = 10;
        int[] sequence = {9,0,3,4,5,8,7,2,2,1,5,7,0,3,4,2};
        QuickFind151 uf = new QuickFind151(N);
        for (int i = 0; i < sequence.length; i+=2) {
            if(uf.connected(sequence[i],sequence[i+1]));
            else {
                uf.union(sequence[i],sequence[i+1]);
            }
        }
        StdOut.println(uf.count()+" components");
    }
}
class QuickFind151{
    private int[] id;   // 分量id（以触点作为索引）
    private int count;  // 分量数量
    public int times=0;
    public QuickFind151(int N){
        //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    public int count()  { return count; }
    public boolean connected(int p,int q)  { return find(p) == find(q); }
    public int find(int p){
        return id[p];
    }
    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            times++;
            if(id[i] == pID)    id[i] = qID;
        }
        count--;
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]+" ");
        }
        System.out.println("times: "+times);
        times=0;
    }
}
