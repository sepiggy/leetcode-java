//package cn.sepiggy.题解.数组.左右指针.lc5;
//
//class Solution {
//    public String longestPalindrome(String s) {
//
//        if (s == null || s.length() == 1) {
//            return s;
//        }
//
//        int len = s.length();
//
//        int leftPointer = 0;
//        int rightPointer = len - 1;
//
//        while (leftPointer <= rightPointer) {
//
//            if (isPalindrome(s.substring(leftPointer, rightPointer + 1))) {
//                return s.substring(leftPointer, rightPointer + 1);
//            }
//
//            leftPointer++;
//            rightPointer--;
//        }
//
//        return "";
//    }
//
//    /**
//     * 判断一个字符串是不是回文串
//     *
//     * @param s
//     * @return
//     */
//    private boolean isPalindrome(String s) {
//
//        if (s == null) {
//            return false;
//        }
//
//        int len = s.length();
//
//        int leftPointer = 0;
//        int rightPointer = len - 1;
//
//        while (leftPointer <= rightPointer) {
//
//            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
//                return false;
//            }
//
//            leftPointer++;
//            rightPointer--;
//        }
//
//        return true;
//    }
//}