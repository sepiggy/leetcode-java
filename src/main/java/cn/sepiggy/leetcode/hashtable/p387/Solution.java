package cn.sepiggy.leetcode.hashtable.p387;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int firstUniqChar(String s) {

        final char[] chars = s.toCharArray();

        final Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}