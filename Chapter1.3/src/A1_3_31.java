import java.util.NoSuchElementException;

/**
 * @Author:Gao
 * @Date:2019-08-11 14:39
 */
/*
实现一个嵌套类DoubleNode用来构造双向链表，其中每一个结点都含有
一个指向前驱元素的引用和一项指向后续元素的引用（如果不存在则为null）
为以下任务实现若干静态方法：在表头插入结点，在表尾插入结点，从表头删除结点，
在指定结点之前插入新节点，在指定结点之后插入新节点，删除指定结点
 */
public class A1_3_31 {
    public static void main(String[] args) {
        DoublyLinkList<Integer> list = new DoublyLinkList<>();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.addTail(3);
        list.addTail(2);
        list.addTail(1);
        list.deleteHead();
        list.deleteTail();
        list.deleteAt(list.first.tail.tail);
        list.addTailAt(list.first,2);
        list.addHeadAt(list.first.tail,3);
        for (int i = 0; i < list.getN(); i++) {
            System.out.print(list.first.item+",");
            list.first = list.first.tail;
        }
//        System.out.println(list.first.item);
//        System.out.println(list.first.tail.item);
//        System.out.println(list.first.head.item);
    }
}
class DoublyLinkList<Item>{
    public class DoubleNode{
        Item item;
        DoubleNode head;
        DoubleNode tail;
    }
    int N = 0;
    DoubleNode first,last;

    public int getN() {
        return N;
    }

    public void addHead(Item item){
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        if(isEmpty()){
            first.head = first;
            first.tail = last;
            last = first;
        }
        else {
            oldFirst.head=first;
            first.head = null;
            first.tail = oldFirst;
        }
        N++;
    }
    public void addTail(Item item){
        DoubleNode oldList = last;
        last = new DoubleNode();
        last.item = item;
        if(isEmpty()){
            last.head = last;
            last.tail = first;
            first = last;
        }
        else {
            oldList.tail = last;
            last.head = oldList;
            last.tail = null;
        }
        N++;
    }
    public void deleteHead(){
        if(isEmpty())   throw new NoSuchElementException("Empty Linklist!");
        first = first.tail;
        first.head = null;
        N--;
    }
    public void deleteTail(){
        if(isEmpty())   throw new NoSuchElementException("Empty Linklist!");
        last = last.head;
        last.tail = null;
        N--;
    }
    public void addHeadAt(DoubleNode node,Item item){
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        DoubleNode current = node.head;
        current.tail = newNode;
        newNode.head = current;
        newNode.tail = node;
        node.head = newNode;
        N++;
    }
    public void addTailAt(DoubleNode node,Item item){
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        DoubleNode current = node.tail;
        current.head = newNode;
        newNode.tail = current;
        newNode.head = node;
        node.tail = newNode;
        N++;
    }
    public void deleteAt(DoubleNode node){
        DoubleNode head = node.head;
        DoubleNode tail = node.tail;
        head.tail = tail;
        tail.head = head;
        N--;
    }
    public boolean isEmpty()    { return N==0; }

}