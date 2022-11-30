package cn.sepiggy.leetcode.hashtable.p136;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {

    Set<Integer> hashSet = new HashSet<>();
    int arraySum = 0;

    public int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            arraySum += nums[i];
        }

        int setSum = 0;
        final Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            setSum += iterator.next();
        }

        return setSum * 2 - arraySum;
    }
}