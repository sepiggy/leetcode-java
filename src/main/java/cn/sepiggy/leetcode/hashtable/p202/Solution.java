package cn.sepiggy.leetcode.hashtable.p202;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean isHappy(int n) {

        Set<Integer> hashSet = new HashSet<>();

        while (hashSet.add(n)) {
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            if (next == 1) {
                return true;
            }
            n = next;
        }
        return false;
    }
}