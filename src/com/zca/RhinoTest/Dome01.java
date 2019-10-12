package com.zca.RhinoTest;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 测试脚本引擎执行javascript代码
 * @author Altria
 * Date: 11/10/2019 下午 8:50
 */
public class Dome01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        // 获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("js");

        // 定义变量, 存储到引擎上下文中
        engine.put("msg", "测试脚本引擎");
        String str = "var user = {name:'zhouchenan', age:18,school:['清华','北大']};";
        str += "print(user.name);";

        // 执行脚本
        engine.eval(str);
        engine.eval("msg = '脚本测试有问题'");
        System.out.println(engine.get("msg"));

        System.out.println("--------------------------------------");
        // 定义脚本函数
        engine.eval("function add(a, b){var sum = a + b; return sum;}");
        //  取得调用接口
        Invocable jsInvoke = (Invocable) engine;
        // 执行脚本中定义的方法
        Object result01 = jsInvoke.invokeFunction("add", new Object[]{13, 25});
        System.out.println(result01);

        // 导入其他java包, 使用其他包中的java类
        // 这里无法像视频那样直接导入了,
        String jsCode = "var list = java.util.Arrays.asList([\"北大\", \"清华\"]);";
        engine.eval(jsCode);

        List<String> list1 = (List<String>) engine.eval("list");
        for (String s:list1) {
            System.out.println(s);
        }

        // 执行一个js文件
        URL url = Dome01.class.getClassLoader().getResource("a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();
    }

}
