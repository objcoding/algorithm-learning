package com.objcoding.algorithm.sort.bubblesort;

/**
 * 冒泡排序
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/15
 */
public class BubbleSort {


    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定排序算法
     */
    public void bubbleSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
