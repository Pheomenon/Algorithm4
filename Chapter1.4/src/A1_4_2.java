
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @Author:Gao
 * @Date:2019-08-12 14:15
 */
/*
修改ThreeSum,正确处理两个较大的int值相加可能溢出的情况
 */
public class A1_4_2 {
    public static int count(BigInteger[] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 1; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if(a[i].add(a[j].add(a[k])).equals(BigInteger.valueOf(0)))
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("F:\\Algorithm4\\Chapter1.4\\src\\1Kints.txt"));
        String textLine;
        String str = "";

        while((textLine=bf.readLine())!=null){
            str+=" "+textLine;
        }
        String[] numbers = str.split(" ");
        BigInteger[] a =new BigInteger[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
            a[i] = BigInteger.valueOf(Integer.parseInt(numbers[i]));
        }
        bf.close();
        System.out.println("sum = "+ count(a));
    }
}
