package com.zca.Javassist;

import javassist.*;

import java.io.IOException;

/**
 * 测试使用javassist生成一个类
 * @author Altria
 * Date: 12/10/2019 上午 12:58
 */
public class JavassistTest01 {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        // 获得一个新的类
        CtClass cc = pool.makeClass("com.zca.Javassist.bean.Emp");

        try {
            // 创建属性
            CtField cf1 = CtField.make("private int empno;", cc);
            CtField cf2 = CtField.make("private String ename;", cc);
            cc.addField(cf1);
            cc.addField(cf2);

            // 创建get/set方法(偷懒只建了一个)
            CtMethod cm1 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
            CtMethod cm2 = CtMethod.make("public int getEmpno(){return this.empno;}", cc);
            cc.addMethod(cm1);
            cc.addMethod(cm2);

            // 创建无参构造器
            CtConstructor ctConstructor1 = new CtConstructor(new CtClass[]{}, cc);
            ctConstructor1.setBody("{}");
            CtConstructor ctConstructor2 = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
            ctConstructor2.setBody("{this.empno = empno;this.ename = ename;}");
            cc.addConstructor(ctConstructor1);
            cc.addConstructor(ctConstructor2);

            cc.writeFile("E:/Java/java_review/src");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
