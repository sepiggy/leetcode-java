package cn.sepiggy.leetcode.recursion.p50;

class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            // 把 n 是 INT_MIN 的情况单独拿出来处理
            // 避免 -n 整型溢出
            return myPow(1 / x, -(n + 1)) / x;
        }

        if (n < 0) {
            return myPow(1 / x, -n);
        }

        if (n % 2 == 1) {
            // n 是奇数
            return (x * myPow(x, n - 1));
        } else {
            // n 是偶数
            double sub = myPow(x, n / 2);
            return (sub * sub);
        }
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final double x = 2.00000;
        final int n = -2;
        final double result = solution.myPow(x, n);
        System.out.println("result = " + result);
    }
}