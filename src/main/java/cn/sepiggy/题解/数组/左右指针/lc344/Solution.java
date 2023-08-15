package cn.sepiggy.题解.数组.左右指针.lc344;

class Solution {
    public void reverseString(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int len = s.length;

        int leftPointer = 0;
        int rightPointer = len - 1;

        while (leftPointer < rightPointer) {

            // 交换左右两个指针指向的字符
            char tmp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = tmp;

            leftPointer++;
            rightPointer--;
        }
    }
}