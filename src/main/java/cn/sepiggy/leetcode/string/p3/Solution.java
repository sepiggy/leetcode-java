package cn.sepiggy.leetcode.string.p3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        final int length = s == null ? 0 : s.length();

        // key: 字符，value: 存在的字符数
        final Map<Character, Integer> map = new HashMap<>(16);

        int left = 0, right = 0;
        int res = 0; // 记录结果

        while (right < length) {

            // c是将要移入窗口的字符
            final char c = s.charAt(right);

            // 增大窗口
            right++;

            // 进行窗口内数据的一系列更新
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Debug
            System.out.printf("map: [%d, %d)\n", left, right);

            // 判断左侧窗口是否要收缩
            while (map.getOrDefault(c, 0) > 1) {
                // d是将要移出窗口的字符
                final char d = s.charAt(left);

                // 缩小窗口
                left++;

                // 进行窗口内数据的一系列更新
                map.put(d, map.get(d) - 1);
            }

            // 更新答案
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        final int ans = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println("ans = " + ans);
    }
}