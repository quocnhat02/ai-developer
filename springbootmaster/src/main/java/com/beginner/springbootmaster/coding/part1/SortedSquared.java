package com.beginner.springbootmaster.coding.part1;

import java.util.Arrays;

public class SortedSquared {
    public static int[] sortedSquared(int[] arr) {
        int left = 0, right = arr.length - 1;
        int[] result = new int[arr.length];
        int index = arr.length - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[index] = (int) Math.pow(arr[left], 2);
                left++;
            } else {
                result[index] = (int) Math.pow(arr[right], 2);
                right--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, 3, 6, 8};
        int[] result = sortedSquared(arr);
        System.out.println(Arrays.toString(result));
    }
}
