package com.objcoding.algorithm.sort.countingsort;

/**
 * 计数排序
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/24
 */
public class CountingSort {


    /**
     * 其实计数排序是桶排序的一种特殊情况，
     * 当要排序的 n 个数据，所处的范围并不大的时候，比如最大值是k，我们就把数据划分成k个桶，
     * 每个桶内的数据值都是相同的，省掉了桶内排序的时间，
     *
     * 也就是计数排序的桶数据内存储的是相同数值元素的个数。
     *
     */


    /**
     * a[n] 原始数据
     * c[k] 数组下标为元素值，存储小于等于k的个数
     * r[n] 排序好的数据
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的范围
        int k = a[0];
        for (int i = 1; i < n; i++) {
            if (k < a[i]) {
                k = a[i];
            }
        }

        // 申请一个计数数组c，大小为k
        int[] c = new int[k];
        // 计算每个元素的个数，见counting_sort_.jpg
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 依次累加,见counting_sort_.jpg
        for (int i = 1; i < k; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 申请一个临时数组r
        int[] r = new int[n];
        // 步骤见counting_sort_4.jpg
        for (int i = 0; i < n; i++) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 最后将排好序的r，拷贝到a中
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }

    }
}
