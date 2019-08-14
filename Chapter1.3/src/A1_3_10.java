/**
 * @Author:Gao
 * @Date:2019-08-10 13:20
 */
/*
编写一个过滤器InfixToPostfix,将算术表达式由中序表达式转换为后序表达式
 */
public class A1_3_10 {
    public static void main(String[] args) {
    String s = "((3+9)*(2-1))/7";
    String ip = new InfixToPostfix().start(s);
        System.out.println(ip);
    }
}
class InfixToPostfix{
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private boolean isBrackets(char ch){
        return ch == ')';
    }
    public String start(String expresion){
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            if(isDigit(expresion.charAt(i))) {
                vals.push(String.valueOf(expresion.charAt(i)));
            }
            else if(isOperator(expresion.charAt(i))){
                ops.push(String.valueOf(expresion.charAt(i)));
            }
            else if(isBrackets(expresion.charAt(i))) {
                String val0 = vals.pop();
                String val1 = vals.pop();
                String op = ops.pop();
                String combine = "("+val1+val0+op+")";
                vals.push(combine);
            }
        }
        while (ops.size() > 0) {
            String val0 = vals.pop();
            String val1 = vals.pop();
            String op = ops.pop();
            String combine = "("+val1+val0+op+")";
            vals.push(combine);
        }
        return vals.pop();
    }
}
