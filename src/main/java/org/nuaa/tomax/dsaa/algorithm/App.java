package org.nuaa.tomax.dsaa.algorithm;

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
    public static void main(String[] args) {
        int dataLength = 100000;
        int max = 100000;
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
        QuickSort.sort(data);
        System.out.println("quicksort time cost : " + (System.currentTimeMillis() - beg));
        for (int i = 0; i < dataLength; i++) {
            assert data[i] == answer[i];
        }

        System.out.println("test success");
    }
}
