package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: ShellSort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-13 09:43
 * @Version: 1.0
 */
public class ShellSort {
    public static void sort(int[] data) {
        int h = 1;
        while (h < data.length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < data.length; i++) {
                for (int j = i; j >= h; ) {
                    int num = j - h;
                    if (data[j] < data[num]) {
                        Sort.swap(data, j, num);
                        j = num;
                    } else {
                        break;
                    }

                }
            }
            h /= 3;
        }
    }
}
