package cn.sepiggy.题解.数组.左右指针.lc125;

class Solution {
    public boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }

        char[] chars = s.toCharArray();

        int len = chars.length;

        int leftPointer = 0;
        int rightPointer = len - 1;

        while (leftPointer < rightPointer) {

            if (!isAlphaDigit(s.charAt(leftPointer))) {
                leftPointer++;
                continue;
            }

            if (!isAlphaDigit(s.charAt(rightPointer))) {
                rightPointer--;
                continue;
            }

            char leftChar = Character.toLowerCase(s.charAt(leftPointer));
            char rightChar = Character.toLowerCase(s.charAt(rightPointer));

            if (leftChar != rightChar) {
                return false;
            }

            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    /**
     * 判断是否是字母或数字
     *
     * @param c
     * @return
     */
    private boolean isAlphaDigit(char c) {

        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = solution.isPalindrome(s);
        System.out.println("palindrome = " + palindrome);

        boolean b = solution.isAlphaDigit(' ');
        System.out.println("b = " + b);
    }
}