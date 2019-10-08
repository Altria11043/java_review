package com.zca.TestFile;

import java.io.File;

/**
 * 测试递归调用file文件
 * @author Altria
 */
public class test_File_03 {
    public static void main(String[] args) {
        File f = new File("E:\\安装包");
        printFile(f, 0);
    }

    public static void printFile(File file, int level){
        for (int i=0; i<level; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();

            for (File temp:files){
                printFile(temp, level+1);
            }
        }
    }
}
