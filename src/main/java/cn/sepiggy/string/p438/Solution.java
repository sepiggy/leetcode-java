package cn.sepiggy.string.p438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        final List<Integer> res = new ArrayList<>();

        final int length = s == null ? 0 : s.length();

        int left = 0, right = 0;

        while (right < length) {
            final char c = s.charAt(right++);

            while (true) {
                final char[] chars = s.substring(left, right).toCharArray();
                Arrays.sort(s.substring(left, right).toCharArray())

            }


        }

    }
}