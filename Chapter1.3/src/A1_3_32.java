/**
 * @Author:Gao
 * @Date:2019-08-14 09:10
 */
/*
Steque。一个栈为目标的队列（或称steque），是一种支持push，pop，和enqueue操作
的数据类型。为这种抽象数据类型定义一份API并给出一份基于链表的实现
 */
public class A1_3_32 {
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.enqueue(4);
        steque.enqueue(5);
        steque.pop();
        steque.pop();
        for (int i = 0; i < steque.getN(); i++) {
            System.out.print(steque.first.item+",");
            steque.first = steque.first.next;
        }
    }
}
class Steque<Item>{
    public class Node{
        Item item;
        Node next;
    }
    int N = 0;
    Node first;
    Node last;

    public int getN() {
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        if(N<2)     last = oldFirst;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public void pop(){
        first = first.next;
        N--;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        if(N<2)     first = oldLast;
        last = new Node();
        last.item = item;
        oldLast.next = last;
        N++;
    }
}
