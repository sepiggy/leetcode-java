package cn.sepiggy.leetcode.recursion.p50;

/**
 * 拆分问题 + 组合子问题
 */
class Solution {

    public double myPow(double x, int n) {

        long N = n; // 将n转换为长整型，避免溢出
        if (n < 0) {
            return myPow(1 / x, -N);
        }
        return myPow(x, N);
    }

    private double myPow(double x, long n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 1) { // n是奇数
            return x * myPow(x, n - 1);
        } else { // n是偶数
            return myPow(x * x, n / 2);
        }
    }
}