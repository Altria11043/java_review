package com.zca.TestMap;

import java.util.*;

/**
 * 测试表格数据的存储
 * @author Altria
 */
public class test_StoreData {
    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 1001);
        map1.put("姓名", "周晨安");
        map1.put("薪资", 10000);
        map1.put("入职日期", "2019-09-09");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 1002);
        map2.put("姓名", "Altria");
        map2.put("薪资", 40000);
        map2.put("入职日期", "2014-04-09");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 1003);
        map3.put("姓名", "Saber");
        map3.put("薪资", 30000);
        map3.put("入职日期", "2017-06-09");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        for (Map<String, Object> m:list){
            Set<String> keyset = m.keySet();
            for (Iterator<String> ite = keyset.iterator(); ite.hasNext();){
                String temp= ite.next();
                System.out.print(temp + ":" + m.get(temp) + "\t");
            }
            System.out.println();
        }
    }
}
