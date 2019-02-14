package org.nuaa.tomax.dsaa.algorithm.search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Name: SearchKthNum
 * @Description: search kth(smallest) num in array
 * @Author: tomax
 * @Date: 2019-02-14 20:45
 * @Version: 1.0
 */
public class SearchKthNum {
    /**
     * search based on partition(one problem is the method will change the array)
     * @param array data array
     * @param k kth
     * @return kth num
     */
    public static int searchByPartition(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        k--;
        while (left < right) {
            int part = partition(array, left, right);
            if (part == k) {
                break;
            } else if (part > k) {
                right = part - 1;
            } else {
                left = part + 1;
            }
        }
        // the kth num of array has been the right num
        return array[k];
    }

    /**
     * search based on heap(size k)
     * @param array data array
     * @param k kth
     * @return kth num
     */
    public static int searchByHeap(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : array) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    private static int partition(int[] array, int left, int right) {
        // TODO : select correct base to partition
        int base = array[left];
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[left] <= base) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[left] = base;
        return left;
    }
}
