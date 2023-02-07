package Tinkoff.Tinkoff.contest._3_;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = 1;
        long b = n - 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                a = n / i;
                b = n / i * (i - 1);
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}
//    HashMap<Integer, Integer> slow(int n){
//        int a, b;
//        int nok = Integer.MAX_VALUE;
//        for (int i = 1; i * 2 <= n; i++) {
//            if (i * (n - i) / )
//
//        }
//    }
//}
