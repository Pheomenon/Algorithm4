/**
 * @Author:Gao
 * @Date:2019-08-18 09:10
 */
/*
一个队列实现的栈，使用一个队列实现一个栈，使得每个栈操作所需的队列操作数量为线性级别。
提示：要删除一个元素，将队列中的所有元素一一出列，除了最后一个元素，应将它删除
并返回；
 */
public class A1_4_28 {
    public static void main(String[] args) {
        Stack428<Integer> stack428 = new Stack428<>();
        stack428.push(1);
        stack428.push(2);
        stack428.push(3);
        stack428.pop();
        while (stack428.first != null) {
            System.out.print(stack428.first.item + " ");
            if (stack428.first.next != null)
                stack428.first = stack428.first.next;
            else break;
            ;
        }
    }
}

class Stack428<Item> {
    public class Node {
        Item item;
        Node next;
    }

    Node first;
    Node last;
    int N = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item pop() {
        Item item = last.item;
        Node current = first;
        while (current.next != last) {
            current = current.next;
        }
        current.next = null;
        return item;
    }

}
