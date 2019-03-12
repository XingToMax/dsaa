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
        int base = data[left];

        // move num below base to its left, num above base to its right
        while (left < right) {
            while (left < right && data[right] >= base) {
                right--;
            }
            if (left < right) {
                data[left] = data[right];
            }

            while (left < right && data[left] <= base) {
                left++;
            }

            if (left < right) {
                data[right] = data[left];
            }
        }
        // move base to its correct place
        data[left] = base;
        // return partition num
        return left;
    }

}
