// package cn.sepiggy.leetcode.array.p5;
//
// /**
//  * https://leetcode.cn/problems/longest-palindromic-substring/
//  */
// class Solution {
//
// 	public String longestPalindrome(String s) {
// 		final char[] chars = s.toCharArray();
// 		for (int i = 0; i < chars.length; i++) {
// 			for (int j = i; j < chars.length; j++) {
//
// 			}
//
// 		}
//
// 	}
//
// 	/**
// 	 * 判断一个字符串是否是回文串
// 	 *
// 	 * @param s
// 	 * @return
// 	 */
// 	static boolean isPalindrome(String s) {
// 		final char[] chars = s.toCharArray();
// 		int left = 0, right = chars.length - 1;
// 		while (left < right) {
// 			if (chars[left] == chars[right]) {
//
// 			}
// 			if (chars[left] != chars[right]) {
// 				return false;
// 			}
// 			left++;
// 			right--;
// 		}
// 		return true;
// 	}
//
// 	public static void main(String[] args) {
// 		System.out.println("isPalindrome(\"xxxyyyyxxx\") = " + isPalindrome("xxxyyyyxxx"));
//
//
// 	}
// }