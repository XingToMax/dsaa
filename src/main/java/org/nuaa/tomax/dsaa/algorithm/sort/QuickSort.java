package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: QuickSort
 * @Description: int array quick sort(increase)
 * @Author: tomax
 * @Date: 2019-02-11 20:45
 * @Version: 1.0
 */
public class QuickSort {
    /**
     * sort data array
     * @param data an array to be sorted
     */
    public static void sort(int[] data) {
        assert data != null;
        quicksort(data, 0, data.length - 1);
    }

    /**
     * sort range left right
     * @param data data to be sorted
     * @param left left side
     * @param right right side
     */
    private static void quicksort(int[] data, int left, int right) {
        if (left < right) {
            // get partition
            int par = partition(data, left, right);
            // sort new range left .. par - 1
            quicksort(data, left, par - 1);
            // sort new range par + 1 .. right
            quicksort(data, par + 1, right);
        }
    }

    /**
     * let base to correct place in data array and get its place as next sort partition
     * @param data data to be sorted
     * @param left left side
     * @param right right side
     * @return partition num
     */
    private static int partition(int[] data, int left, int right) {
        // choose base
        int mid = (left + right) / 2;
        // check whether mid is the base or not
        boolean checkBase = (data[mid] > data[left] && data[mid] < data[right])
                || (data[mid] < data[left] && data[mid] > data[right]);
        if (checkBase) {
            swap(data, left, mid);
        }
        // check whether right is the base or not
        checkBase = (data[right] > data[left] && data[right] < data[mid]) ||
                (data[right] < data[left] && data[right] > data[mid]);
        if (checkBase) {
            swap(data, left, right);
        }

        // get base value
        int base = data[left];

        // move num below base to its left, num above base to its right
        while (left < right) {
            while (left < right && data[right] >= data[base]) {
                right--;
            }
            if (left < right) {
                data[left] = data[right];
            }

            while (left < right && data[left] <= data[base]) {
                left++;
            }

            if (left < right) {
                data[left] = data[right];
            }
        }
        // move base to its correct place
        data[left] = base;
        // return partition num
        return left;
    }

    /**
     * swap data[a] and data[b]
     * @param data an array
     * @param a a index
     * @param b b index
     */
    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
