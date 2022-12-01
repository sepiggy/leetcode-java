package cn.sepiggy.leetcode.hashtable.p350;

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        final Map<Integer, Integer> nums1Map = new HashMap<>();
        final Map<Integer, Integer> nums2Map = new HashMap<>();

        for (int i : nums1) {
            if (nums1Map.containsKey(i)) {
                nums1Map.put(i, nums1Map.get(i) + 1);
            } else {
                nums1Map.put(i, 1);
            }
        }

        for (int i : nums2) {
            if (nums2Map.containsKey(i)) {
                nums2Map.put(i, nums2Map.get(i) + 1);
            } else {
                nums2Map.put(i, 1);
            }
        }

        final Set<Integer> nums1KeySet = nums1Map.keySet();
        final Set<Integer> nums2KeySet = nums2Map.keySet();
        final Set<Integer> interSection = new HashSet<>();

        for (Integer aNums1Key : nums1KeySet) {
            if (nums2KeySet.contains(aNums1Key)) {
                interSection.add(aNums1Key);
            }
        }

        final List<Integer> resultList = new ArrayList<>();

        for (Integer aNum : interSection) {
            final int min = Math.min(nums1Map.get(aNum), nums2Map.get(aNum));
            for (int i = 0; i < min; i++) {
                resultList.add(aNum);
            }
        }

        final int[] resultArray = new int[resultList.size()];

        int i = 0;
        for (Integer item : resultList) {
            resultArray[i++] = item;
        }

        return resultArray;
    }
}