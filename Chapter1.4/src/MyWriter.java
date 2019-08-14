import edu.princeton.cs.algs4.StdRandom;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @Author:Gao
 * @Date:2019-08-12 14:50
 */
public class MyWriter {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("F:\\Algorithm4\\Chapter1.4\\src\\1Kints.txt");
        for (int i = 0; i < 1000; i++) {
            int nums = StdRandom.uniform(-100000,100000);
            String data = String.valueOf(nums)+"\r";
            file.write(data);
        }
        file.close();
    }
}
