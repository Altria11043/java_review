package com.zca.TestFile;

import java.io.File;
import java.util.Date;

/**
 * file常用方法
 * @author Altria
 */
public class test_File_02 {
    public static void main(String[] args) {
        File f = new File("F:\\1.txt");
        System.out.println("File是否存在：" + f.exists());
        System.out.println("File是否是目录：" + f.isDirectory());
        System.out.println("File是否是文件：" + f.isFile());
        System.out.println("File最后修改时间：" + new Date(f.lastModified()));
        System.out.println("File的大小：" + f.length());
        System.out.println("File的文件名：" + f.getName());
        System.out.println("File的目录路径：" + f.getPath());
        // 获取到当前文件的绝对路径
        System.out.println("File的目录路径：" + f.getAbsolutePath());

        File f2 = new File("D:\\测试\\java");
//        boolean flag = f2.mkdir();  // 目录结构中有以恶搞不存，则不会创建整个目录树
        boolean flag = f2.mkdirs(); // 目录结构中有一个不存在的也没有关系，会创建整个目录树
        System.out.println("\n当前目录是否存在：" + flag);
    }
}
