package cn.sepiggy.leetcode.tree.playground.demo001;

/**
 * ??????
 */
public class Main001 {

    static void traverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }

        // ????
        System.out.println(arr[i]);
        traverse(arr, i + 1);
        // ????
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        traverse(a, 0);
    }
}
