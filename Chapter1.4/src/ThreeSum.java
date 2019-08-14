import edu.princeton.cs.algs4.StdOut;

import java.io.*;

/**
 * @Author:Gao
 * @Date:2019-08-12 14:16
 */
public class ThreeSum {
    public static int count(int [] a){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if(a[i]+a[j]+a[k]==0)
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
        int[] a = new int[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
            a[i]=Integer.parseInt(numbers[i]);
        }
        bf.close();
        System.out.println("sum = "+count(a));
    }
}


