package mytasks.evennumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrInput = scanner.nextLine().split(" ");
        int n = Integer.parseInt(arrInput[0]);          // k <= n
        int k = Integer.parseInt(arrInput[1]);          //

        arrInput = scanner.nextLine().split(" ");
        int beautiful = 0;
        int count;
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arrInput[i]);
        }

        int max = find(nums, k);

        System.out.println(max);

    }

    static int find(int[] nums, int k){
        Map<Integer, Integer> visitedIntegers = new HashMap<>();
        int maxLenght = 0;
        int skips = 0;
        for (int right = 0, left = 0; right < nums.length; right++){
            int copyK = k;
            int currentInt = nums[right]%2;
            if (right+1 != nums.length && nums[right+1]%2 != 0 && k!=skips) {
                skips++;
            }

            maxLenght = Math.max(maxLenght, right - left + 1 );
        }
        return maxLenght;
    }

}








