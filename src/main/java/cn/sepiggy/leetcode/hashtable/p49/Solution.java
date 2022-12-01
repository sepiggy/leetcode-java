package cn.sepiggy.leetcode.hashtable.p49;

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        final Map<String, List<String>> map = new HashMap<>();
        final List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        for (String key : map.keySet()) {
            final List<String> stringList = map.get(key);
            result.add(stringList);
        }

        return result;
    }

    public static void main(String[] args) {

        String[] ss = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        final Solution solution = new Solution();
        final List<List<String>> lists = solution.groupAnagrams(ss);
        System.out.println("lists = " + lists);
    }
}