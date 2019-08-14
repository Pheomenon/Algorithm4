import edu.princeton.cs.algs4.StdIn;
/**
 * @Author:Gao
 * @Date:2019-08-09 19:53
 */
/*
编写一个Stack的用例Parentheses，从标准输入中读取一个文本流
并使用栈判定其中的括号是否配对完整。例如，对于[()]{}{[()()]()}程序打印true
对于[(])则打印false
 */
public class A1_3_4 {
    public static void main(String[] args) {
        Stack<Character> Parentheses = new Stack<>();
        int flag = 0;
        String Str = StdIn.readString();
        for (int i = 0; i < Str.length(); i++) {
            Character item = Str.charAt(i);
            if(item.equals('(')) Parentheses.push(item);
            else if(item.equals('[')) Parentheses.push(item);
            else if(item.equals('{')) Parentheses.push(item);
            else if(item.equals(')')) {
                if(!Parentheses.pop().equals('(')){
                    flag++;break;
                }
            }
            else if(item.equals(']')) {
                if(!Parentheses.pop().equals('[')){
                    flag++;break;
                }
            }
            else if(item.equals('}')) {
                if(!Parentheses.pop().equals('{')){
                    flag++;break;
                }
            }
        }
        if(!Parentheses.isEmpty()) System.out.println("False");
        else if(flag==0)     System.out.println("True");
//        Stack<Character> Parentheses = new Stack<>();
//        int flag = 0;
//        while (!StdIn.isEmpty()){
//            Character item = StdIn.readChar();
//            if(item.equals('(')) Parentheses.push(item);
//            else if(item.equals('[')) Parentheses.push(item);
//            else if(item.equals('{')) Parentheses.push(item);
//            else if(item.equals(')')) {
//                if(!Parentheses.pop().equals('(')){
//                    flag++;
//                }
//            }
//            else if(item.equals(']')) {
//                if(!Parentheses.pop().equals('[')){
//                    flag++;
//                }
//            }
//            else if(item.equals('}')) {
//                if(!Parentheses.pop().equals('{')){
//                    flag++;
//                }
//            }
//        }
//        if(!Parentheses.isEmpty()) System.out.println("False");
//        else if(flag==0)     System.out.println("True");
    }
}
