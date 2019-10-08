package Test_Array;

/**
 * 测试数组
 * @author Altria
 */
public class test_Array_04 {
    static test_Array_02 t2 = new test_Array_02();
    public static void main(String[] args){
        test_arrayCopy();
    }

    public static void test_arrayCopy(){
        //public static void arraycopy(@NotNull Object src,  （被拷贝的数组）
        //                             int srcPos,           （数组中从那个下标开始拷贝内容）
        //                             @NotNull Object dest, （接收拷贝内容的数组）
        //                             int destPos,          （拷贝的内容从指定的位置开始存放）
        //                             int length)           （拷贝的内容长度）
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 2, s2, 1, 2);
        System.out.println(t2.OutArray(s2));
    }

}
