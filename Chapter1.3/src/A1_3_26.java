/**
 * @Author:Gao
 * @Date:2019-08-11 09:15
 */
/*
编写一个remove方法，接受一条链表和字符串key作为参数，
删除链表中的所有item域为key的结点
 */
public class A1_3_26 {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        list.append("question");
        list.append("a ");
        list.append("is ");
        list.append("this ");
        list.append("be ");
        list.append("to ");
        list.append("not ");
        list.append("or ");
        list.append("be ");
        list.append("to ");
        list.remove(list.first,"be ");
        while (list.first!=null){
            System.out.print(list.first.item);
            list.first = list.first.next;
        }
    }
}
class LinkList<Item>{
    public class Node{
        Item item;
        Node next;
    }
    Node first;
    int N = 0;
    public void append(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public void remove(Node node,Item key){
        Node current = first;
        while (current.next!=null){
            if(current.next.item.equals(key)){
                    current.next = current.next.next;
                if(current.next==null)
                    return;
            }
            current = current.next;
        }
    }
}
