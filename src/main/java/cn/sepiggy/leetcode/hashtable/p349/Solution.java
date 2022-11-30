package cn.sepiggy.leetcode.hashtable.p349;

import java.util.*;

class Solution {

    // ??nums1?nums2????????????
    public int[] intersection(int[] nums1, int[] nums2) {

        final Set<Integer> nums1Set = new HashSet<>();
        final Set<Integer> intersect = new HashSet<>();
        final int[] result;

        // ?nums1????
        for (int i : nums1) {
            nums1Set.add(i);
        }

        for (int i : nums2) {
            if (nums1Set.contains(i)) {
                intersect.add(i);
                nums1Set.remove(i);
            }
        }

        result = new int[intersect.size()];
        int i = 0;
        for (Integer integer : intersect) {
            result[i++] = integer;
        }

        return result;
    }
}