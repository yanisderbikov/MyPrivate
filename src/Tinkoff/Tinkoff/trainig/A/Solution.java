package Tinkoff.Tinkoff.trainig.A;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  str = scanner.nextLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        int D = Integer.parseInt(str[3]);

        System.out.println(getSol(A, B, C, D));


    }
    static int getSol(int A, int B, int C, int D){
        if (D <= B){
            return A;
        }
        return A + (D - B) * C;

    }
}
