package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 抛出异常，谁调用谁处理
 * @author Altria
 */
public class test_Exception_03 {
    public static void main(String[] args) {
        try {
            readMyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMyFile() throws IOException {
        FileReader reader = new FileReader("F:\\1.txt");
        char c1 = (char) reader.read();
        System.out.println(c1);

        if (reader!=null)
            reader.close();

    }
}