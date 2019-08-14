import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-13 10:27
 */
/*
为StaticSETofInts（表1.2.15）添加一个实例方法howMany()，
找出给定键的出现次数且在最坏情况下所需的运行时间和logN成正比
 */
public class A1_4_11 {
    public static void main(String[] args) {
        int[] keys = {2,3,42,1,2,5,2,6,8,4,64,3,2,5,3,8,6,9,6,4,3,1};
        StaticSETofInts set = new StaticSETofInts(keys);
        System.out.println(set.howMany(2));
    }
}
class StaticSETofInts{
    private int a[];
    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    public boolean contains(int key)    {return rank(key) != -1;}
    public int rank(int key){
        int lo = 0;
        int hi = a.length-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(a[mid] == key) return mid;
            else if(key>a[mid]) lo = mid+1;
            else if(key<a[mid]) hi = mid-1;
        }
        return -1;
    }
    public int howMany(int key){
        int lKey = rank(key),rKey = rank(key);
        if(!contains(key)){
            System.out.println("Not Exist");
            return -1;
        }
        int count = 1;
        while (lKey!=0&&a[--lKey] == key){
            count++;
        }
        while (rKey!=a.length&&a[++rKey] == key){
            count++;
        }
        return count;
    }
}
