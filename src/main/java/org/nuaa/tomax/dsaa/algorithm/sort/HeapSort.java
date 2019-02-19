package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: QuickSort
 * @Description: int array heap sort(increase)
 * @Author: tomax
 * @Date: 2019-02-19 20:45
 * @Version: 1.0
 */
public class HeapSort {

    /**
     * sort the array(heap sort)
     * @param data data array
     */
    public static void sort(int[] data) {
        // adjust the heap to a big head heap
        for (int i = (data.length - 1) / 2; i >= 0; i--) {
            heapAdjust(data, i, data.length);
        }

        // move the biggest to the end and adjust to keep the head is the largest range in [0 .. i)
        for (int i = data.length - 1; i > 0; i--) {
            // move the largest to the end
            swap(data, 0, i);
            // index after i is sorted
            heapAdjust(data, 0, i);
        }
    }

    /**
     * adjust the heap as a big head heap
     * @param data data array
     * @param i i index
     * @param length adjust length
     */
    private static void heapAdjust(int[] data, int i, int length) {
        int index = i;
        // from top to down to adjust node
        while (index * 2 < length) {
            index *= 2;
            // choose the bigger one in two sons
            if (index + 1 < length && data[index] < data[index + 1]) {
                index++;
            }
            if (data[i] < data[index]) {
                swap(data, i, index);
                i = index;
            } else {
                break;
            }
        }
    }

    /**
     * swap data[a], data[b]
     * @param data data array
     * @param a a index
     * @param b b index
     */
    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
