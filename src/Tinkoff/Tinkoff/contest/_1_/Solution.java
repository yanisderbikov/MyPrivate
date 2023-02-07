package Tinkoff.Tinkoff.contest._1_;

import java.util.Scanner;

public class Solution {

//    есть ошибка при след. варианте
//    27
//    Algorithms and Data Structures
//    BBBBBBBBBBBYBYYYYBBBBBBBBBB

    public static void main(String[] args) {
        System.out.println(sol());
    }
    static int sol(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] s = scanner.nextLine().toCharArray();
//        какая-то байда еще тут
        char[] t = scanner.nextLine().toCharArray();
        int ans = 0;
        String last = "";
        boolean good = true;
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' '){
                if (!good){
                    ans++;
                }
                last = "";
                good = true;
            }else {
                if (last == ""){
                    last = "" + t[j];
                } else {
                    if (last.charAt(0) == t[j]){
                        good = false;
                    }
                    last = "" + t[j];
                }
                j++;
            }
        }
        return ans;
    }
}
