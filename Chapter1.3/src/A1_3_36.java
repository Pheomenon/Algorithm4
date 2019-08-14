import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-14 17:56
 */
/*
随机迭代器。为上一题的RandomQueue<Item>编写一个迭代器，随机返回队列中的所有元素
 */
public class A1_3_36 {
    public static void main(String[] args) {
        RandomQueueWithIterator<Integer> randomQueueWithIterator = new RandomQueueWithIterator<>();
        randomQueueWithIterator.enqueue(1);
        randomQueueWithIterator.enqueue(2);
        randomQueueWithIterator.enqueue(3);
        randomQueueWithIterator.enqueue(4);
        randomQueueWithIterator.enqueue(5);
        for (Integer i:randomQueueWithIterator) {
            System.out.print(i+" ");
        }
    }
}
class RandomQueueWithIterator<Item> implements Iterable<Item> {
    Item[] items = (Item[]) new Object[1];
    int N = 0;
    public boolean isEmpty()    { return N == 0; }
    private Item[] resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
        return items;
    }
    public void enqueue(Item item){
        if(N == items.length)   resize(2*items.length);
        items[N++] = item;
    }
    public Item dequeue(){
        Item temp;
        int random;
        random = StdRandom.uniform(N);
        temp = items[random];
        items[random] = items[N-1];
        items[N-1] = temp;
        items[N-1] = null;
        N--;
        return temp;
    }
    public Item sample(){
        Item temp;
        int random;
        random = StdRandom.uniform(N);
        temp = items[random];
        return temp;
    }

    @Override
    public Iterator<Item> iterator(){ return new ListIterator(); }
    private class ListIterator implements Iterator<Item> {
        public void remove() { }
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            int n = StdRandom.uniform(i);
            Item temp = items[n];
            items[n] = items[--i];
            return temp;
        }
    }
}
