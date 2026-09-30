package ArrraySample;

import java.util.Arrays;

public class TwoArray {
    public static void main(String[] args) {
        // 二维数组
        int[][] ns = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(ns));
        System.out.println("遍历二维数组");
        for (int[] arr : ns) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
