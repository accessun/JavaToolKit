package io.github.accessun.string;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SplitStringWithRegex {
    
    @Test
    public void testSplit() {
        String words = "keyword1 keyword2  keyword3";
        String[] list = words.split("\\s+");
        for (String string : list) {
            System.out.println(string);
        }
        
        words = "HelloWorld";
        list = words.split("\\s+");
        for (String string : list) {
            System.out.println(string);
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testJoinArrayList() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(StringUtils.join(list));
        list.addAll(new ArrayList<>());
        System.out.println(StringUtils.join(list));
    }
    
    private void splitBySemiColon(String words) {
        System.out.println("====================");
        String[] list = words.split(";|；");
        for (String s : list) {
            s = s.trim();
            System.out.println(s);
        }
    }
    
    @Test
    public void testSplitBySemiColon() {
        String testStr1 = "aaa;bbb; ccc ;ddd ; eee";
        String testStr2 = ";aaa;bbb; ccc ;ddd ; eee;";
        String testStr3 = "；aaa；bbb；ccc ；ddd ； eee； ";
        String testStr4 = "；aaa；bbb; ccc ;ddd ；eee;";
        String testStr5 = "  aaa ";
        
        splitBySemiColon(testStr1);
        splitBySemiColon(testStr2);
        splitBySemiColon(testStr3);
        splitBySemiColon(testStr4);
        splitBySemiColon(testStr5);
    }
    
    @Test
    public void testStringBuildSlice() {
        StringBuilder sb = new StringBuilder("aaa;bbb;key word;");
        System.out.println(sb.substring(0, sb.length() - 1));
    }
    
    @Test
    public void testDeleteHead() {
        String str = "tj_web02.sunxin";
        String head = "tj_web02";
        
        System.out.println(str.replaceFirst(head + ".", ""));
    }
    
    public void replaceDotWithUnderscore(String[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i].replaceAll("\\.", "_");
        }
    }
    
    @Test
    public void testReplace() {
        String[] liStrings = { "dasd.da.ds", "dsadds.s", "ds" };
        for (String s : liStrings)
            System.out.println(s);
        System.out.println("======================");
        replaceDotWithUnderscore(liStrings);
        for (String s : liStrings)
            System.out.println(s);
    }
    
}
