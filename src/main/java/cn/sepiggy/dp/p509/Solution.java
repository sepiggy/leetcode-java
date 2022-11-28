package cn.sepiggy.dp.p509;

/**
 * https://leetcode.cn/problems/fibonacci-number/
 */
class Solution {

	/**
	 * @param n 0 <= n <= 30
	 * @return
	 */
	public int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
}