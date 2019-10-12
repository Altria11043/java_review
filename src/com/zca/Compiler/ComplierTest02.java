package com.zca.Compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 通过反射运行编译好的类
 * @author Altria
 * Date: 11/10/2019 下午 7:04
 */
public class ComplierTest02 {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "C:/myjava/Helloworld.java");
        System.out.println(result==0?"编译成功":"编译失败");

        try {
            URL[] urls = new URL[]{new URL("file:/C:/myjava/")};
            // 通过类加载器(ClassLoader)加载指定的类
            URLClassLoader loader = new URLClassLoader(urls);
            Class clz = loader.loadClass("Helloworld");

            // 调用加载类的main方法
            clz.getMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
