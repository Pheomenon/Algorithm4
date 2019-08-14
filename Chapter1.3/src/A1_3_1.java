/**
 * @Author:Gao
 * @Date:2019-08-09 19:37
 */
/*
为FixedCapacityStack添加一个isFull（）方法
 */
public class A1_3_1 <Item>{
    private Item[] a;
    private int N;
    public A1_3_1(int cap){
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        a[N++] = item;
    }
    public Item pop(){
        return a[--N];
    }
    public boolean isFull(){
        return a.length == N;
    }
}
