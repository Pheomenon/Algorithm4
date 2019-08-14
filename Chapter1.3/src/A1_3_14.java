import com.sun.xml.internal.stream.util.ReadOnlyIterator;

import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-10 15:45
 */
/*
编写一个类ResizingArrayQueueOfStrings,使用定长数组实现队列的抽象，然后扩展实现，使用调整数组的方法突破大小限制
 */
public class A1_3_14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("k");
        queue.enqueue("i");
        queue.enqueue("l");
        queue.enqueue("o");
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue());
        }
    }
}
class ResizingArrayQueueOfStrings{
    private String[] a = new String[1];
    private int N;
    private int head=0;
    public boolean isEmpty()    {return N == 0;}
    public int size()   {return N;}
    private void resize(int max){
        String[] temp = new String[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a=temp;
    }
    public void enqueue(String item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public String dequeue(){
        String item = "";
            item = a[head++];
        if(N>0&&N==a.length/4) resize(a.length/2);
        N--;
        return item;
    }
}
