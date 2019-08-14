import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
/**
 * @Author:Gao
 * @Date:2019-08-14 16:46
 */
/*
随机队列.随机队列能够存储一组元素并支持以下API
泛型随机背包的API
public class RandomQueue<Item> implements Iterable<Item>
             RandomQueue()        创建一个空随机队列
     boolean isEmpty()            队列是否为空
        void enqueue(Item item)   添加一个元素
        Item dequeue()            删除并随机返回一个元素（取样不放回）
        Item sample()             随机返回一个元素但不删除它（取样且放回）
编写一个RandomQueue类来实现这份API。提示：使用能动态调整大小的数组表示数据。
删除一个元素时，随机交换某个元素（索引在0和N-1之间）和末位元素（索引为N-1）
的位置，然后像ResizingArrayStack一样删除并返回末位元素。编写一个用例，使用
RandomQueue<Card>在桥牌中发牌（每人13张）
 */
public class A1_3_35 {
    public static void main(String[] args) {
        RandomQueue<Card> bridgeCards = new RandomQueue<>();
        for (int i = 0; i < 4 ; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card();
                switch (i){
                    case 0:
                        card.type = "Club";
                        break;
                    case 1:
                        card.type = "Diamonds";
                        break;
                    case 2:
                        card.type = "Hearts";
                        break;
                    case 3:
                        card.type = "Spades";
                        break;
                    default:
                        System.out.println("Error");
                        return;
                }
                card.value = j;
                bridgeCards.enqueue(card);
            }
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println("Player: "+i+":");
            for (int j = 0; j < 13; j++) {
                Card card = bridgeCards.dequeue();
                StdOut.printf("%9s %2d",card.type,card.value);
            }
            System.out.println();
        }

    }
}
class Card{
    public String type;
    public int value;
}
class RandomQueue<Item>{
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
        random = StdRandom.uniform(0,N);
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
        random = StdRandom.uniform(0,N);
        temp = items[random];
        return temp;
    }

//    @Override
//    public Iterator<Item> iterator(){
//        return new ListIterator();
//    }

//    private class ListIterator implements Iterator<Item>{
//        int current = 0;
//        boolean flag = false;
//        public boolean hasNext(){
//            return current < N;
//        }
//        public void remove(){   }
//        public Item next(){
//            if(!flag){
//                for (int i = 0; i < N; i++) {
//                    Item temp;
//                    int random = StdRandom.uniform(0,N);
//                    temp = items[i];
//                    items[i] = items[random];
//                    items[random] = temp;
//                }
//                flag = true;
//            }
//            Item item = items[current];
//            current++;
//            return item;
//        }
//    }
}
