package com.objcoding.algorithm.sort.mergesort;

/**
 * 归并排序
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/23
 */
public class MergeSort {


    /**
     * 递推公式：
     * merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     *
     * 终止条件：
     * p >= r 不用再继续分解
     *
     */


    /**
     * 时间复杂度 O(nlogn)
     * 稳定排序算法
     */
    public static void mergeSort(int[] a, int n) {
        mergeSort(a, 0, n-1);
    }

    private static void mergeSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        // 分治递归
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        // 归并
        merge(a, p, q, r);
    }

    /**
     * 申请一个临时数组 tmp，大小与 A[p…r] 相同,
     * 用两个游标 i 和 j，分别指向 A[p…q] 和 A[q+1…r] 的第一个元素，
     * 比较这两个元素 A[i] 和 A[j]，如果 A[i]<=A[j]，我们就把 A[i] 放入到临时数组 tmp，
     * 并且 i 后移一位，否则将 A[j] 放入到数组 tmp，j 后移一位。
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p];
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }


        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 4, 3};
        mergeSort(a, 5);
    }

}
