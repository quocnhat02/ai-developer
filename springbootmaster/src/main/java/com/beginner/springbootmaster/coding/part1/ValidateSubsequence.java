package com.beginner.springbootmaster.coding.part1;

public class ValidateSubsequence {
    public static boolean isSubsequence(int[] arr, int[] subsequence) {
        int indexSubsequence = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == subsequence[indexSubsequence]) {
                indexSubsequence++;
            }
        }

        return indexSubsequence == subsequence.length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] subsequence = {5, 3};
        boolean checkSubSequence = isSubsequence(arr, subsequence);
        System.out.println(checkSubSequence);
    }
}
