/**
 * @Author:Gao
 * @Date:2019-08-10 15:17
 */
/*
编写一个可迭代的Stack用例，它含有一个静态的copy()方法，
接受一个字符串的栈作为参数并返回该栈的一个副本。
 */
public class A1_3_12 {
    public static void main(String[] args) {
        Stack<String> test = new Stack<>();
        test.push("hello");
        test.push("world");
        Stack<String> replica = new Stack<>();
        replica = test;
        System.out.println(replica.pop());
    }
}
