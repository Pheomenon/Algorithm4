import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author:Gao
 * @Date:2019-08-14 10:06
 */
/*
Deque.一个双向队列（或者称为deque)和栈或队列类似，但他同时支持在两端添加
或删除元素。deque能够存储一组元素并支持以下API
泛型双向队列的API：
public class Deque<Item> implements Iterable<Item>
             Deque()                创建空双向队列
     boolean isEmpty()              双向对列是否为空
         int size()                 双向对列中的元素数量
        void pushLeft(Item item)    向左端添加一个元素
        void pushRight(Item item)   向右端添加一个元素
        Item popLeft()              从左端删除一个元素
        Item popRight()             从右端删除一个元素
编写一个使用双向链表实现这份API的Deque类，
以及一个使用动态数组调整事项这份API的ResizingArrayDeque类。
 */
public class A1_3_33 {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.popLeft();
        deque.popRight();
        for(Integer result : deque){
            System.out.print(result+",");
        }
        System.out.println();
        ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<>();
        resizingArrayDeque.pushLeft(1);
        resizingArrayDeque.pushLeft(2);
        resizingArrayDeque.pushLeft(3);
        resizingArrayDeque.pushRight(1);
        resizingArrayDeque.pushRight(2);
        resizingArrayDeque.pushRight(3);
        resizingArrayDeque.popLeft();
        resizingArrayDeque.popRight();
        for(Integer result : resizingArrayDeque){
            System.out.print(result+",");
        }
    }
}

class Deque<Item> implements Iterable<Item>{
    public class DoubleNode{
        Item item;
        DoubleNode head;
        DoubleNode tail;
    }
    DoubleNode first;
    DoubleNode last;
    int N = 0;
    boolean isEmpty()   { return N==0; }
    int size()          { return N; }
    public void pushLeft(Item item){
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        if(isEmpty()){
            first.head = first;
            first.tail = last;
            last = first;
        }
        else {
            first.head = null;
            first.tail = oldFirst;
            oldFirst.head = first;
        }
        N++;
    }
    void pushRight(Item item){
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        if(isEmpty()){
            last.head = last;
            last.tail = first;
            first = last;
        }
        else {
            oldLast.tail = last;
            last.head = oldLast;
            last.tail = null;
        }
        N++;
    }
    public Item popLeft(){
        if(isEmpty()) throw new NoSuchElementException("Deque is empty!");
        Item item = first.item;
        first = first.tail;
        first.head = null;
        N--;
        return item;
    }
    public Item popRight(){
        if(isEmpty()) throw new NoSuchElementException("Deque is empty!");
        Item item = last.item;
        last = last.head;
        last.tail = null;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        DoubleNode current = first;
        public boolean hasNext(){
            return current !=null;
        }
        public void remove(){   }
        public Item next(){
            Item item = current.item;
            current = current.tail;
            return item;
        }
    }
}
class ResizingArrayDeque<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1]; //Deque元素
    private int N = 0;                         //元素数量
    boolean isEmpty()   { return N==0; }
    int size()          { return N; }
    private void resize(int max){
        //将Deque移动到一个大小为max的数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    public void pushLeft(Item item){
        if(N == a.length) resize(2*a.length);
        for (int i = N-1; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = item;
        N++;
    }
    public void pushRight(Item item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public void popLeft(){
        if(isEmpty()) throw new NoSuchElementException("Empty deque!");
        a[0] = null;
        for (int i = 0; i < N-1; i++) {
            a[i] = a[i+1];
        }
        N--;
        if(N > 0 && N == a.length/4)    resize(a.length/2);
    }
    public void popRight(){
        if(isEmpty()) throw new NoSuchElementException("Empty deque!");
        a[N--] = null;
        if(N > 0 && N == a.length/4)    resize(a.length/2);
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private int i = 0;
        public boolean hasNext(){
            return i < N;
        }
        public void remove(){   }
        public Item next(){
            return a[i++];
        }
    }
}
