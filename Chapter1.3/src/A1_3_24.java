/**
 * @Author:Gao
 * @Date:2019-08-10 20:56
 */
/*
编写一个方法removeAfter()，接受一个链表结点作为参数并删除该节点的后续结点
如果参数结点或参数结点的后续结点为空则什么都不做
 */
public class A1_3_24 {
    public static void main(String[] args) {
        LinkList324<String> list = new LinkList324<>();
        list.append("be ");
        list.append("or ");
        list.append("not ");
        list.append("be ");
        list.append("this ");
        list.append("is ");
        list.append("a ");
        list.append("question");
        list.removeAfter(list.first.next.next.next.next.next);
        while (list.first.next!=null){
            System.out.println(list.first.item);
            list.first = list.first.next;
        }
    }
}
class LinkList324<Item> {
    public class Node{
        Item item;
        Node next;
    }
    Node first;
    int N=0;
    public void append(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public void removeAfter(Node node){
        if(node.next==null) return;
        else if(node.item == null) return;
        Node current = first;
        while (current.next!=null){
            if(current.item == node.item)   {
                current.next.next=null;
                return;
            }
            current = current.next;
        }
    }
}
