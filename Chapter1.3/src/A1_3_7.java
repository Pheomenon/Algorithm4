/**
 * @Author:Gao
 * @Date:2019-08-10 10:37
 */
/*
为Stack添加一个方法peer()，返回栈中最近添加的元素而不弹出它
 */
public class A1_3_7 {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(100);
        System.out.println(test.peer());
        test.push(200);
        test.push(300);
        test.pop();
        System.out.println(test.peer());
    }
}
