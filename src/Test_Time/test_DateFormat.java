package Test_Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的相互转换
 * @author Altria
 */
public class test_DateFormat {
    public static void main(String[] args) {
        // 把时间转换成指定的字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(new Date());
        System.out.println(str);


        // 把字符串转换成时间
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = df2.parse("2020-02-15 13:59:10");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 测试其他的格式字符
        DateFormat df3 = new SimpleDateFormat("D");
        String str2 = df3.format(new Date());
        System.out.println(str2);
    }
}
