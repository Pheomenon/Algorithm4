/**
 * @Author:Gao
 * @Date:2019-08-11 09:52
 */
/*
编写一个方法max()，接受一条链表的首节点作为参数，返回链表中键最大的结点的值。
假设所有的键均为正整数，如果链表为空则返回(用递归解题)
*/
public class A1_3_28 {
    public static void main(String[] args) {
        LinkList328 list = new LinkList328();
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
class LinkList328{
    public class Node{
        int item;
        Node next;
    }
    Node first;
    int N=0;
    int max=0;
    Node current;
    public void append(int item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        current = first;
        N++;
    }
    int max(Node node){
        if(node == null) return -1;
        if(node.next == null)    return max;
            if(current.item>max) {
                max = current.item;
            }
            if(current.next!=null) current = current.next;
        return max(current.next);
    }
}
