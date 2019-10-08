package Test_Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author Altria
 */
public class test_Calendar_02 {
    public static void main(String[] args) {
        System.out.println("请输入日期（格式：2019-2-14）");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        // 在执行下面的语句之前应该先把获得的日期保存一下
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // 这里必须先置为1，不然在下面的循环中会以给定的日期开头循环
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 获取每个月有多少天，不能把这段代码放进循环判断语句中，否则会计算下个月的最大天数，导致结果出错
        int d = calendar.getActualMaximum(Calendar.DATE);
//        System.out.println(d);
        for (int i=0; i<calendar.get(Calendar.DAY_OF_WEEK)-1; i++){
            System.out.print("\t");
        }

        for (int i=0; i<d; i++){
            if(day == calendar.get(Calendar.DAY_OF_MONTH)){
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "*\t");
            }else{
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");

            }


            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                System.out.println();

            if (i == calendar.getActualMaximum(Calendar.DATE))
                break;

            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

    }
}
