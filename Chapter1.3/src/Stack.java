import java.util.Iterator;

/**
 * @Author:Gao
 * @Date:2019-08-09 19:56
 */
public class Stack<Item> {
    private class Node{
        Item item;
        Node next;
    }
    private Node first; //栈顶
    private int N; //元素数量
    public boolean isEmpty(){   return first == null;   } //或:N==0
    public int size(){  return N;  }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Item peer(){
        Item item = first.item;
        return item;
    }
    static public Stack<String> copy(Stack<String> demo){
        Stack<String> replica = new Stack<>();
        demo.first = replica.first;
        return replica;
    }

    public Iterator<Item> itemIterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current !=null;
        }
        public void remove(){   }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
