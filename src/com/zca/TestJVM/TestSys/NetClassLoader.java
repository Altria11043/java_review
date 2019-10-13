package com.zca.TestJVM.TestSys;

import java.io.*;
import java.net.URL;

/**
 * 网络类加载器, 未进行测试
 * @author Altria
 * Date: 13/10/2019 上午 10:52
 */
public class NetClassLoader extends  ClassLoader{
    // 定义一个根目录
    private String rootUrl;

    public NetClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        // 判断是否加载过这个类
        if (c!=null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try{
                c = parent.loadClass(name); // 委托给父类加载
            }catch (Exception e){
//                e.printStackTrace();
            }
            if (c!=null){
                return c;
            }else{
                // 如果父类还是没有加载到, 就由自己加载
                byte[] classData = getClassData(name);
                if (classData == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String classname){
        String path = rootUrl + "/" + classname.replace(".", "/") + ".class";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = null;
        try{
            URL url = new URL(path);
            is = url.openStream();
            byte[] buffer = new byte[1024];
            int temp = -1;
            while((temp=is.read(buffer))!=-1){
                baos.write(buffer, 0, temp);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally{
            try {
                if (null!=is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}