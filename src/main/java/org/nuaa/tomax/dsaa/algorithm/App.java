package org.nuaa.tomax.dsaa.algorithm;

import org.nuaa.tomax.dsaa.algorithm.search.SearchKthNum;
import org.nuaa.tomax.dsaa.algorithm.sort.HeapSort;
import org.nuaa.tomax.dsaa.algorithm.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Name: App
 * @Description: TODO
 * @Author: Tomax
 * @Date: 2019-02-11 20:41
 * @Version: 1.0
 */
public class App {
    public static void testQuickSort() {
        int dataLength = 1000000;
        int max = 1000000;
        int[] data = new int[dataLength];
        int[] answer = new int[dataLength];
        Random random = new Random();

        // generate data
        IntStream.range(0, dataLength).forEach(i -> {
            int num = random.nextInt(max);
            data[i] = num;
            answer[i] = num;
        });

        long beg = System.currentTimeMillis();
        Arrays.sort(answer);
        System.out.println("lib time cost : " + (System.currentTimeMillis() - beg));
        beg = System.currentTimeMillis();
        HeapSort.sort(data);
        System.out.println("quicksort time cost : " + (System.currentTimeMillis() - beg));
        for (int i = 0; i < dataLength; i++) {
            assert data[i] == answer[i];
        }

        System.out.println("test success");
    }

    public static void testSearchKthNum() {
        // -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        int[] array = new int[] {
                3, 9, 0, -2, 8, 4, 5, 1, 6, -1, 10, 7, 2
        };
        System.out.println(SearchKthNum.searchByPartition(Arrays.copyOf(array, array.length), 1));
        System.out.println(SearchKthNum.searchByPartition(Arrays.copyOf(array, array.length), 5));
        System.out.println(SearchKthNum.searchByPartition(Arrays.copyOf(array, array.length), 8));
        System.out.println(SearchKthNum.searchByPartition(Arrays.copyOf(array, array.length), 13));

        System.out.println(SearchKthNum.searchByHeap(Arrays.copyOf(array, array.length), 1));
        System.out.println(SearchKthNum.searchByHeap(Arrays.copyOf(array, array.length), 5));
        System.out.println(SearchKthNum.searchByHeap(Arrays.copyOf(array, array.length), 8));
        System.out.println(SearchKthNum.searchByHeap(Arrays.copyOf(array, array.length), 13));
    }

    public static void testHeapSort() {
        int[] data = new int[]{3, 1, 6, 9, 2, 8, 0, 7, 4, 5, 1000, 766, 2, 5, 212, 314, 45, 45};
        HeapSort.sort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        testQuickSort();
    }
}
