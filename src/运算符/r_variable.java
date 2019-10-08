package 运算符;

public class r_variable {
    public static void main(String[] args) {
        // byte 数据类型是8位、有符号的，以二进制补码表示的整数
        // 最小值是 -128（-2^7）；
        // 最大值是 127（2^7-1）；
        byte b = 127;
        System.out.println("" + b);
        // short 数据类型是 16 位、有符号的以二进制补码表示的整数
        // 最小值是 -32768（-2^15）；
        // 最大值是 32767（2^15 - 1）；
        short st = 321;
        System.out.println(st);
        //int 数据类型是32位、有符号的以二进制补码表示的整数；
        //最小值是 -2,147,483,648（-2^31）；
        //最大值是 2,147,483,647（2^31 - 1）；
        int i = 100000;
        System.out.println(i);
        //long 数据类型是 64 位、有符号的以二进制补码表示的整数；
        //最小值是 -9,223,372,036,854,775,808（-2^63）；
        //最大值是 9,223,372,036,854,775,807（2^63 -1）；
        long l = 99999999;
        System.out.println(l);
        //float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
        //float 在储存大型浮点数组的时候可节省内存空间；
        // 如果后面不加f则默认为double类型
        float ft = 1.024f;
        System.out.println(ft);
        //double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
        //浮点数的默认类型为double类型；
        //double类型同样不能表示精确的值，如货币；
        double de = 1.024;
        System.out.println(de);
        //boolean数据类型表示一位的信息；
        //只有两个取值：true 和 false；
        boolean bln = true;
        System.out.println(bln);
        //char类型是一个单一的 16 位 Unicode 字符；
        //最小值是 \u0000（即为0）；
        //最大值是 \uffff（即为65,535）；
        // 这里需要注意一点，char的字符只能在单引号中使用
        char c1 = 'A';
        char c2 = '\u0061';
        System.out.println(c1 + ":" + c2);
    }
}
