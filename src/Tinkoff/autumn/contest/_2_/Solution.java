package Tinkoff.autumn.contest._2_;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        long a = Integer.parseInt(input1[0]);
        long b = Integer.parseInt(input1[1]);
        long c = Integer.parseInt(input1[2]);

        long x = Integer.parseInt(input2[0]);
        long y = Integer.parseInt(input2[1]);
        long z = Integer.parseInt(input2[2]);

        long sum = x/a + y/b + z/c + 2;
        System.out.println((sum*(sum-1))/2L);

    }
}
