import java.util.Scanner;
public class A1_1_3 {
    public static void main(String[] args) {
        System.out.println("Input three number");
        int num0,num1,num2;
        Scanner input = new Scanner(System.in);
        num0 = input.nextInt();
        num1 = input.nextInt();
        num2 = input.nextInt();
        if(num0==num1&&num1==num2)
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
