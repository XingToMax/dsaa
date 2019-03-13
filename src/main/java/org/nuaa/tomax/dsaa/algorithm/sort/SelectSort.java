package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: SelectSort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-13 10:45
 * @Version: 1.0
 */
public class SelectSort {
    public static void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (i != min) {
                Sort.swap(data, i, min);
            }
        }
    }
}
