package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: BubbleSort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-12 22:36
 * @Version: 1.0
 */
public class BubbleSort {
    public static void sort(int[] data) {
        boolean update = true;
        for(int i = 0; i < data.length && update; i++) {
            update = false;
            for (int j = i; j < data.length; j++) {
                if (data[i] > data[j]) {
                    Sort.swap(data, i, j);
                    update = true;
                }
            }
        }
    }
}
