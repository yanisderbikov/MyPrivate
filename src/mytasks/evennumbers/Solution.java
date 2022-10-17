package mytasks.evennumbers;

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


        for (int i = 0; i < n; i++) {
            count = 0;
            if (nums[i]%2 == 0){
                count++;
                for (int j = i; j < nums.length - i; j++) {
                    if(nums[j]%2 == 0){
                        count++;
                    } else {
                        int likeK = k;
                        for (int l = j; l < nums.length - j; l++) {
                            if (nums[l]%2 != 0 && likeK != 0){
                                count++;
                                likeK--;
                                l++;
                            }
                        }
                    }
                }
            }
            beautiful = Math.max(beautiful, count);
        }

        System.out.println(beautiful);




    }
}
