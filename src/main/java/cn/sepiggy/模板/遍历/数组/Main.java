package cn.sepiggy.模板.遍历.数组;

/**
 * 数组的两种遍历方式：
 * 1) 迭代
 * 2) 递归
 */
public class Main {

    /**
     * 迭代遍历数组
     *
     * @param arr
     */
    static void traverse1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 递归遍历数组
     *
     * @param arr
     * @param i
     */
    static void traverse2(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }

        // 前序位置
//        System.out.println(arr[i]);

        traverse2(arr, i + 1);

        // 后序位置
        System.out.println(arr[i]);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//        traverse1(arr);
        traverse2(arr, 0);
    }
}
