/**
 * @Author:Gao
 * @Date:2019-08-10 10:42
 */
/*
编写一段程序，从标准输入读取一个缺少一个左括号的表达式并打印出补全括号之后的中序表达式
输入：
1+2)*3-4)*5-6)))
输出
((1+2)*((3-4)*(5-6)))
 */
public class A1_3_9 {
        private boolean isOperator(char ch) {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        private boolean isDigit(char ch) {
            return ch >= '0' && ch <= '9';
        }

        public static void main(String[] args) {
            String str = "1+2)*3-4)*5-6)))";
            A1_3_9 cp = new A1_3_9();
            String res = cp.completeParentheses(str);
            System.out.println(res);
        }

    private String completeParentheses(String str) {
        Stack<String> optrStack = new Stack<>();
        Stack<String> dataStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                // 处理数字的情况
                dataStack.push(String.valueOf(str.charAt(i)));
            } else if (isOperator(str.charAt(i))) {
                // 处理操作符的情况
                optrStack.push(String.valueOf(str.charAt(i)));
            } else {
                // 处理右括号的情况
                String d2 = dataStack.pop();
                String d1 = dataStack.pop();
                String opt = optrStack.pop();
                String exstr = "(" + d1 + opt + d2 + ")";
                dataStack.push(exstr);
            }
        }

//        while (optrStack.size() > 0) {
//            String opt = optrStack.pop();
//            String d2 = dataStack.pop();
//            String d1 = dataStack.pop();
//            String exstr = "(" + d1 + opt + d2 + ")";
//            dataStack.push(exstr);
//        }
        return dataStack.pop();
    }
}
