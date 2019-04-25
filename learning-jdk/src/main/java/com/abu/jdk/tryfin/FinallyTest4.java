package com.abu.jdk.tryfin;

import java.util.HashMap;
import java.util.Map;

public class FinallyTest4 {
    public static void main(String[] args) {
        System.out.println(getMap().get("KEY").toString());
    }

    /**
     * Output: FINALLY
     * 值传递, 对象copy, 类似FinallyTest3
     * @return
     */
    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("KEY", "INIT");
        try {
            map.put("KEY", "TRY");
            return map;
        } catch (Exception e) {
            map.put("KEY", "CATCH");
        } finally {
            map.put("KEY", "FINALLY");
            map = null;
        }
        return map;
    }
}
