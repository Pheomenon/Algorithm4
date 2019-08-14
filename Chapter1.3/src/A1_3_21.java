/**
 * @Author:Gao
 * @Date:2019-08-10 20:22
 */
/*
编写一个方法find()，接受一条链表和一个字符串key作为参数。
如果链表中的某个节点的item域的值为key，则方法返回true，否则返回false
 */
public class A1_3_21 {
    public static void main(String[] args) {
        linkList321<String> list = new linkList321<>();
        list.append("to ");
        list.append("be ");
        list.append("or ");
        list.append("not ");
        list.append("be ");
        list.append("this ");
        list.append("is ");
        list.append("a ");
        list.append("question");
        boolean bool = list.find(list,"to ");
        System.out.println(bool);
    }
}
class linkList321<Item>{
    public class Node{
        Item item;
        Node next;
    }
    Node first;
    int N=0;
    public void append(Item item){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        N++;
    }

    public boolean find(linkList321 list,Item item){
        int temp = N;
        Node current = list.first;
        while (current.next!=null){
            if(current.next.item==item)     return true;
            else current = current.next;
        }
        return false;
    }
}

