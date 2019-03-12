package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: MergeSort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-12 23:48
 * @Version: 1.0
 */
public class MergeSort {
    static int[] temp;
    public static void sort(int[] data) {
        temp = new int[data.length];
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int l, int r) {
        if (l < r) {
            int mid =  (r + l) / 2;
            sort(data, l, mid);
            sort(data, mid + 1, r);
            merge(data, l, r, mid);
        }
    }

    private static void merge(int[] data, int l, int r, int m) {
        int a = l;
        int b = m + 1;

        int count = 0;

        while (a <= m && b <= r) {
            if (data[a] <= data[b]) {
                temp[count++] = data[a++];
            } else {
                temp[count++] = data[b++];
            }
        }

        while (a <= m) {
            temp[count++] = data[a++];
        }

        while (b <= r) {
            temp[count++] = data[b++];
        }

        System.arraycopy(temp, 0, data, l, count);
    }
}
