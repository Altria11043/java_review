package com.zca.TestJVM.TestSys;

import java.io.*;

/**
 * 自定义文件系统类加载器
 * @author Altria
 * Date: 13/10/2019 上午 10:52
 */
public class FileSystemClassLoader extends  ClassLoader{
    // 定义一个根目录
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
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
        String path = rootDir + "/" + classname.replace(".", "/") + ".class";
        try(InputStream is = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();){

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
        }
    }
}