package io.github.accessun.temp;

import java.util.HashMap;
import java.util.Map;

public class Temp {
    
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("aa", "AA");
        System.out.println(map.get("aaa"));
    }
}
