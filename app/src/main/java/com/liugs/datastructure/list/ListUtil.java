package com.liugs.datastructure.list;

import java.util.LinkedHashMap;

public class ListUtil {

     public static void main(String [] args){
         LinkedHashMap<String, String> accessOrderTrue = new LinkedHashMap<>(16, 0.75f, false);
         accessOrderTrue.put("1","1");
         accessOrderTrue.put("2","2");
         accessOrderTrue.put("3","3");
         accessOrderTrue.put("4","4");
         System.out.println("acessOrderTure"+accessOrderTrue);
         accessOrderTrue.get("2");
         accessOrderTrue.get("3");
         System.out.println("获取了数据"+accessOrderTrue);
     }
}
