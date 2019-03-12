package org.nuaa.tomax.dsaa.algorithm;

import org.nuaa.tomax.dsaa.algorithm.search.SearchKthNum;
import org.nuaa.tomax.dsaa.algorithm.sort.BubbleSort;
import org.nuaa.tomax.dsaa.algorithm.sort.HeapSort;
import org.nuaa.tomax.dsaa.algorithm.sort.QuickSort;
import org.nuaa.tomax.dsaa.algorithm.sort.Sort;

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
    public static void testSort(Sort sort, String name, int dataLength, int max) {
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
        sort.sort(data);
        System.out.println(name + " time cost : " + (System.currentTimeMillis() - beg));
        for (int i = 0; i < dataLength; i++) {
            if (data[i] != answer[i]) {
                System.out.println("error");
                return;
            }
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

    public static void testQuickSort() {
        testSort(QuickSort::sort, "quick", 10000, 10000);
    }

    public static void testHeapSort() {
        testSort(HeapSort::sort, "heap", 100000, 100000);
    }

    public static void testBubbleSort() {
        testSort(BubbleSort::sort, "bubble", 1000, 1000);
    }

    public static void main(String[] args) {
        testQuickSort();
    }
}
