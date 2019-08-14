/**
 * @Author:Gao
 * @Date:2019-08-10 19:41
 */
/*
编写一个方法delete()，接受一个int参数k，删除链表的的第k个元素
 */
public class A1_3_20 {
    public static void main(String[] args) {
        linkList<String> list = new linkList<>();
        list.append("to ");
        list.append("be ");
        list.append("or ");
        list.append("not ");
        list.append("be ");
        list.append("this ");
        list.append("is ");
        list.append("a ");
        list.append("question");
        list.delete("not ");
    }
}
class linkList<Item>{
    int N=0;
    Node first;
    public class Node{
        Item item;
        Node next;
    }
    public void append(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public void delete(Item item){
        int temp = N;
        Node current = first;
        while (current.next!=null){
            if(current.next.item==item)  {
                System.out.println("Success!");
                current.next = current.next.next;
                N--;
                break;
            }
            current=current.next;
        }
        if(temp==N) System.out.println("Not found!");
    }
}
