package Yandex.training.acid;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length =  scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int result = iteration(array);
        System.out.println(result);
    }

    static int iteration(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i], second = nums[i + 1];
            int target = 0;
            if (first < second) {
                target = second - first;
            } else if (first > second) {
                target = second - first;
            }
            if ((list.size() == 0 || list.contains(target)) && target != 0) {
                list.add(target);
            }
        }
        if (list.size() > 1) {
            return -1;
        } else {
            return list.get(0);
        }
    }
}
