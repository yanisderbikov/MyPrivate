package tests;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

// "static void main" must be defined in a public class.
public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 3, 9, 9 };

        // target exists
        // returns the leftmost index
        print(nums);
        System.out.println("=== target exists ===");
        int[] exists = {1,2,3,6,9};
        for (int i : exists) System.out.println("index of " + i + " = " + binarySearch(nums, i));

        // target does not exist
        // returns the index of where the it should be
        System.out.println("=== target does not exist: index of where it should be ===");
        int[] notExists = {0, -100, 4, 10, 100};
        for (int i : notExists) System.out.println("index of " + i + " = " + binarySearch(nums, i));

        // verify target exists
        System.out.println("=== verify target exists ===");
        int[] verify = {1,3,0,7,10};
        for (int i : verify) {
            int index = binarySearch(nums, i);
            boolean contains = index < nums.length && i == nums[index];
            System.out.println("nums contains " + i + ": " + contains);
        }
    }
    // If the target exists, returns its leftmost index.
    // Else, returns the index of where it should be.
    static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    static void print(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums)
            list.add(num + "");
        System.out.println("nums = [" + String.join(",", list) + "]");
    }
}