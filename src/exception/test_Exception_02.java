package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 编译器异常
 * @author Altria
 */
public class test_Exception_02 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("F:\\1.txt");
            char c1 = (char) reader.read();
            System.out.println(c1);
        // 以下异常子类在上父类在下
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (reader!=null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
