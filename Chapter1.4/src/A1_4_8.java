import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author:Gao
 * @Date:2019-08-12 20:58
 */
/*
计算文件中相等的整数对数量，用Array.sort()给出线性对数级的解答
 */
public class A1_4_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("F:\\Algorithm4\\Chapter1.4\\src\\1Mints.txt"));
        String textLine;
        String str = "";
        int count=0;
        while((textLine=bf.readLine())!=null){
            str+=" "+textLine;
        }
        String[] numbers = str.split(" ");
        int[] a = new int[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
            a[i]=Integer.parseInt(numbers[i]);
        }
        bf.close();
        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            int temp=a[i];
            int j=i;
            while (j<a.length-1){
                if(temp==a[i+1])    count++;
                j++;
            }
        }

        System.out.println("Same: "+count);
    }
}
