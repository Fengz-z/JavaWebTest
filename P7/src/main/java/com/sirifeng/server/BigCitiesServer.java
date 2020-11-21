package com.sirifeng.server;

import java.util.HashMap;
import java.util.Map;

public class BigCitiesServer {

    public static Map<String, String> getCityCapitals() {
        Map<String, String> map = new HashMap<>();
        map.put("俄罗斯", "莫斯科");
        map.put("日本", "东京");
        map.put("中国", "北京");
        return map;
    }

    public static Map<String, String[]> getBigCities() {
        Map<String, String[]> map = new HashMap<>();
        map.put("澳大利亚", new String[]{"悉尼","墨尔本","布里斯班"});
        map.put("日本", new String[] {"纽约","洛杉矶","加利福尼亚"});
        map.put("中国", new String[] {"北京","上海","深圳"});
        return map;
    }

}
