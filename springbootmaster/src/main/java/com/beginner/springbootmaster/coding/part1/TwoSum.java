package com.beginner.springbootmaster.coding.part1;


import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashNums = new Hashtable<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashNums.get(complement) != null) {
                int index = hashNums.get(complement);
                return new int[]{index, i};
            }
            hashNums.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
