package com.zca.reflection;

import com.zca.reflection.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射操作泛型
 * @author Altria
 * Date: 10/10/2019 下午 12:59
 */
public class Dome05 {

    public void test01(Map<String, User> map, List<User> list){
        System.out.println("Dome04.test01");
    }
    public Map<Integer, User> test02(){
        System.out.println("Dome04.test02");
        return null;
    }
    public static void main(String[] args) {
        try {
            // 获得到了Dome05下的test01对象
            Method method01 = Dome05.class.getMethod("test01", Map.class, List.class);
            // 获得带泛型参数类型(Generic: 泛型, Parameter: 参数)
            Type[] types = method01.getGenericParameterTypes();
            for (Type paramType:types){
                // 这里把带泛型的参数详情打印出来了
                System.out.println("#" + paramType);
                // 强制转型前先进行类型判断
                if (paramType instanceof ParameterizedType){
                    // 获得泛型中的类型数据, 这个可能包含多个泛型, 所以返回值是数组类型
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType:genericTypes){
                        System.out.println("泛型类型: " + genericType);
                    }
                }
            }

            //获得指定方法返回值泛型信息
            Method method02 = Dome05.class.getMethod("test02", null);
            // 获得带泛型参数的返回类型(Generic: 泛型, Return: 返回)
            Type returnType = method02.getGenericReturnType();
            // 强制转型前的判断
            if (returnType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
                for (Type genericType: genericTypes){
                    System.out.println("返回值的泛型类型: " + genericType);
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
