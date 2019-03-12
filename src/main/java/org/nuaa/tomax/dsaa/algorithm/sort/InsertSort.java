package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: InsertSort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-12 23:43
 * @Version: 1.0
 */
public class InsertSort {
    public static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    Sort.swap(data, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
