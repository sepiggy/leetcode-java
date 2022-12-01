package cn.sepiggy.leetcode.hashtable.p205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public boolean isIsomorphic(String s, String t) {

        final Map<Character, Character> map = new HashMap<>();
        final Set<Character> visitedSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (map.containsKey(sc) && map.get(sc) != tc) {
                return false;
            }
            // 不满足一一对应的关系
            if (!map.containsKey(sc) && visitedSet.contains(tc)) {
                return false;
            }
            map.put(sc, tc);
            visitedSet.add(tc);
        }
        return true;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final boolean isomorphic = solution.isIsomorphic("bbbaaaba", "aaabbbba");
        System.out.println("isomorphic = " + isomorphic);
    }
}