package org.nuaa.tomax.dsaa.algorithm.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Name: RadixSort
 * @Description: int array radix sort(increase)
 * @Author: tomax
 * @Date: 2019-02-21 23:27
 * @Version: 1.0
 */
public class RadixSort {
    private static final int[] RADIX_ARRAY = new int[] {
        1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000
    };

    private static final int BARRIER_NUM = 10;

    public static void sort(int[] data, int digitNum) {
        Queue<Integer>[] queues = new Queue[BARRIER_NUM];
        IntStream.range(0, BARRIER_NUM).forEach(i -> queues[i] = new LinkedList<>());
        IntStream.range(1, digitNum + 1).forEach(i -> {
            distribute(data, i, queues);
            collect(data, queues);
        });
    }

    private static void distribute(int[] data, int digit, Queue<Integer>[] queues) {
        IntStream.range(0, data.length).forEach(
                i -> queues[getDigit(data[i], digit)].offer(data[i]));
    }

    private static void collect(int[] data, Queue<Integer>[] queues) {
        AtomicInteger index = new AtomicInteger(0);
        IntStream.range(0, BARRIER_NUM).forEach(i -> {
            while (!queues[i].isEmpty()) {
                data[index.getAndIncrement()] = queues[i].peek();
            }
        });
    }

    private static int getDigit(int num, int d) {
        return (num / RADIX_ARRAY[d - 1]) % 10;
    }

    private static int getDigitNum(int num) {
        int digit = 0;
        while (num != 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }
}
