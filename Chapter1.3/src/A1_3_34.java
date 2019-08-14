import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
/**
 * @Author:Gao
 * @Date:2019-08-14 11:01
 */
/*
随机背包。随机背包能存储一组元素并支持以下API
泛型随机背包的API:
public class RandomBag<Item> implements Iterable<Item>
            RandomBag()         创建一个空随机背包
    boolean isEmpty()           背包是否为空
        int size()              背包中的元素数量
       void add(Item item)      添加一个元素
编写一个RandomBag类来实现这份API。请注意，除了形容词随机外，这份API和Bag的API是相同的。
这意味着迭代应该随机访问背包中的所有元素（对于每次迭代，所有的N！种排列出现的可能性均相同）
提示：用数组保存所有的元素并在迭代器的构造函数中随机打乱它们的顺序。
 */
public class A1_3_34 {
    public static void main(String[] args) {
        RandomBag<Integer> bag = new RandomBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        bag.add(6);
        bag.add(7);
        for (Integer i: bag) {
            System.out.print(i+",");
        }
    }
}

class RandomBag<Item> implements Iterable<Item>{
    Item[] items = (Item[]) new Object[1];
    int N = 0;
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    public void add(Item item){
        if(N == items.length)   resize(items.length*2);
        items[N++] = item;
    }

    public boolean isEmpty()    { return N==0; }
    public int size()           { return N; }
    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        int current = 0;
        boolean flag = false;
        public boolean hasNext(){
            return current < N;
        }
        public void remove(){   }
        public Item next(){
            if(!flag){
                for (int i = 0; i < N; i++) {
                    Item temp;
                    int random = StdRandom.uniform(0,N);
                    temp = items[i];
                    items[i] = items[random];
                    items[random] = temp;
                }
                flag = true;
            }
            Item item = items[current];
            current++;
            return item;
        }
    }
}