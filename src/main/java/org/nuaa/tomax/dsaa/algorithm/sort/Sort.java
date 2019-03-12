package org.nuaa.tomax.dsaa.algorithm.sort;

/**
 * @Name: Sort
 * @Description: TODO
 * @Author: tomax
 * @Date: 2019-03-12 22:24
 * @Version: 1.0
 */
@FunctionalInterface
public interface Sort {
    /**
     * method to sort data
     * @param data data
     */
    void sort(int[] data);

    /**
     * swap data[a], data[b]
     * @param data data array
     * @param a a index
     * @param b b index
     */
    static void swap(int[] data, int a, int b) {
        data[b] = data[a] ^ data[b];
        data[a] = data[a] ^ data[b];
        data[b] = data[a] ^ data[b];
    }
}
