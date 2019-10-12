package com.zca.Compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @author Altria
 * Date: 11/10/2019 下午 6:43
 */
public class ComplierTest01 {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "C:/myjava/Helloworld.java");
        System.out.println(result==0?"编译成功":"编译失败");

        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp c:/myjava/ Helloworld");
        InputStream is = process.getInputStream();
        // 字节流转字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println(info);
        }

    }
}
