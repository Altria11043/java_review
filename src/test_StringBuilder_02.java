/**
 * 测试StringBuilder、StringBuffer可变字符序列的常用方法
 * @author Altria
 */
public class test_StringBuilder_02 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            char temp = (char)('a'+i);
            sb.append(temp);
        }
        System.out.println(sb);
        sb.reverse();   // 倒序
        System.out.println(sb);
        sb.setCharAt(5, '周');   // 替换字符
        System.out.println(sb);

        sb.insert(9, '晨').insert(13, '安');  // 插入字符
        System.out.println(sb);

        sb.delete(19, 20).delete(22, 24);
        System.out.println(sb);

    }
}
