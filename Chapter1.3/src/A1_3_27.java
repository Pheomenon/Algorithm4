/**
 * @Author:Gao
 * @Date:2019-08-11 09:41
 */
/*
编写一个方法max()，接受一条链表的首节点作为参数，返回链表中键最大的结点的值。
假设所有的键均为正整数，如果链表为空则返回0
 */
public class A1_3_27 {
    public static void main(String[] args) {
        LinkList327 list = new LinkList327();
        list.append(93);
        list.append(3242);
        list.append(834);
        list.append(923423);
        list.append(3);
        list.append(234);
        list.append(5325);
        list.append(214);
        list.append(42345);
        int max = list.max(list.first);
        System.out.println(max);
    }
}
class LinkList327{
    public class Node{
        int item;
        Node next;
    }
    Node first;
    int N=0;
    public void append(int item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public int max(Node node){
        if(node == null)    return -1;
        int max=0;
        Node current = first;
        while (current.next!=null){
            if(current.item>max){
                max = current.item;
            }
            current = current.next;
        }
        return max;
    }
}
