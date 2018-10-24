package com.objcoding.algorithm.sort.selectionsort;

/**
 * 选择排序
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/15
 */
public class SelectionSort {


    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 不稳定排序算法
     */
    public static void selectionSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {

            int min = array[i];
            int j = i + 1;

            // 找到未排序区最小元素下标
            int flag = i;
            for (; j < n; j++) {
                if (array[j] < min) {
                    flag = j;
                }
            }

            // 交换
            if (flag != i) {
                int tmp = array[i];
                array[i] = array[flag];
                array[flag] = tmp;
            }

        }

    }


    public static void main(String[] args) {

        int[] array = new int[]{2, 5, 3, 8, 5, 7, 3};

        selectionSort(array, array.length);


        return;
    }
}
