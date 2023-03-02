package Yandex.internWinter.A_DONE;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolutionA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
        }
        String out = code(input);
        System.out.println(out);
    }
    static String code (String[] input){
        String out = "";
        if (input.length == 0) return out;

        for (int i = 0; i < input.length - 1; i++) {
            out = out + parse(input[i]) + " ";
        }
        out = out + parse(input[input.length - 1]);

        return out;
    }
    static String parse (String str){
//        step one : count chars, repeating exclude
        String[] input = str.split(",");
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                set.add(input[i].charAt(j));
            }
        }
        int sizeOfSet = set.size();

//        step second : sum of nums in day and month
        int day = Integer.parseInt(input[3]);
        int mon = Integer.parseInt(input[4]);
        int sumAtDayAndMonth = 0;

        while (day != 0 || mon != 0 ){
            sumAtDayAndMonth = sumAtDayAndMonth + day%10 + mon%10;
            mon = mon == 0 ? 0 : mon/10;
            day = day == 0 ? 0 : day/10;
        }

//        find an alphabet number
        char firstCharAtSecondName = input[0].toUpperCase().charAt(0);
        int placeAtAlphabet = firstCharAtSecondName - 'A' + 1;

//        result at hex
        int resultAtHex = sizeOfSet + sumAtDayAndMonth * 64 + placeAtAlphabet * 256;

        int i = resultAtHex;
        String hex = Integer.toHexString(i);
        String out = hex.length() > 3 ? hex.substring(hex.length() - 3) : hex;
        out = out.toUpperCase();

        return out;

    }
}
