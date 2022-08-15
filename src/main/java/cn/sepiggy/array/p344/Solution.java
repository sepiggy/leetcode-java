package cn.sepiggy.array.p344;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reverse-string/
 */
class Solution {
	public static void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			char tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
		reverseString(chars);
		System.out.println(Arrays.toString(chars));
	}
}