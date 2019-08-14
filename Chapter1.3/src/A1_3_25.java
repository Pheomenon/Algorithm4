/**
 * @Author:Gao
 * @Date:2019-08-10 21:25
 */
/*
编写一个方法insertAfter(),接受两个链表结点最参数，将第二个结点插入链表并使之成为
第一个结点的后续结点(如果两个参数为空则什么都不做)
 */
public class A1_3_25 {
    public static class Node{
        String item;
        Node next;
    }

    public static Node append(Node list,String item) {
        Node oldfirst = list;
        list = new Node();
        list.item = item;
        list.next = oldfirst;
        return list;
    }
    public static Node insertAfter(Node firstList,Node secondList){
        if (firstList == null && secondList == null){ return null;}
        else if (firstList == null && secondList != null) return secondList;
        else if (firstList != null && secondList == null) return firstList;
        else {
            Node connetion = firstList.next;
            firstList.next = secondList;
            Node current = firstList;
            while (current.next != null){
                current = current.next;
            }
            current.next = connetion;
            return firstList;
        }

    }
    public static void main(String[] args) {
        Node Linklist = new Node();
        Node seondlist = new Node();
        Linklist = null;
        seondlist = null;

        Linklist = append(Linklist,"hello");
        Linklist = append(Linklist,"java");
        Linklist = append(Linklist,"world");


        seondlist = append(seondlist,"mereder");
        seondlist = append(seondlist,"python");
        //Linklist 为 world->java->hello
        // secondlist 为 python->mereder
        Node result = insertAfter(Linklist,seondlist);
        //处理结果为 world->python->mereder->java->hello
        while(result != null){
            System.out.println(result.item);
            result = result.next;
        }
    }
}

