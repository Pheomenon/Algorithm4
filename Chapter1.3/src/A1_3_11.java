/**
 * @Author:Gao
 * @Date:2019-08-10 14:41
 */
/*
编写一段程序EvaluatePostfix,从标准输入中的到一个后缀表达式，求值并打印结果
 */
public class A1_3_11 {
    public static void main(String[] args) {
        String s = "(((39+)(21-)*)6/)";
        double ip = new EvaluatePostfix().start(s);
        System.out.println(ip);
    }
}

class EvaluatePostfix{
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private boolean isBrackets(char ch){
        return ch == ')';
    }
    public double start(String expresion){
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        double result=0,val0,val1;
        String combine = " ";
        for (int i = 0; i < expresion.length(); i++) {
            if(isDigit(expresion.charAt(i))) {
                vals.push(String.valueOf(expresion.charAt(i)));
            }
            else if(isOperator(expresion.charAt(i))){
                ops.push(String.valueOf(expresion.charAt(i)));
            }
            else if(isBrackets(expresion.charAt(i))) {
                if(expresion.charAt(i-1) == '+') {
                    val0 = Double.parseDouble(vals.pop());
                    val1 = Double.parseDouble(vals.pop());
                    result = val1+val0;
                }
                else if(expresion.charAt(i-1) == '-') {
                    val0 = Double.parseDouble(vals.pop());
                    val1 = Double.parseDouble(vals.pop());
                    result = val1-val0;
                }
                else if(expresion.charAt(i-1) == '*') {
                    val0 = Double.parseDouble(vals.pop());
                    val1 = Double.parseDouble(vals.pop());
                    result = val1*val0;
                }
                else if(expresion.charAt(i-1) == '/') {
                    val0 = Double.parseDouble(vals.pop());
                    val1 = Double.parseDouble(vals.pop());
                    result = val1/val0;
                }
                else if(expresion.charAt(i-1) == '%') {
                    val0 = Double.parseDouble(vals.pop());
                    val1 = Double.parseDouble(vals.pop());
                    result = val1%val0;
                }
                combine = Double.toString(result);
                vals.push(combine);
            }
        }
        return Double.parseDouble(vals.pop());
    }
}
