package com.objcoding.algorithm.sort;

/**
 * 插入排序
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/15
 */
public class InsertionSort {


    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定排序算法
     */
    public void insertionSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i - 1;
            // 查找插入位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    // 如果未排序的value比已排序的元素大，则将已排序的元素往后移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }
    }

}
