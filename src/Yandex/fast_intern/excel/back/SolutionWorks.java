package Yandex.fast_intern.excel.back;

import java.util.*;
import java.util.Scanner;

public class SolutionWorks {
    static Map<String, Integer> results = new HashMap<>();
    static Map<String, String> formula = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (Integer.parseInt(input[0])==1){
                int value = Integer.parseInt(input[1]);
                results.put("C"+i, value);
            } else {
                results.put("C"+i, null);
                formula.put("C"+i, input[1]);
            }
        }
        String string = print();
        if (string.equals("-1")) System.out.println(-1); else
            results.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(x -> System.out.println(x.getValue().toString()));

    }
    static String print() {
        for (var pair : formula.entrySet()){
            int sum = parseStr(formula.get(pair.getKey()));
            if (sum == -1) return String.valueOf(-1);
            results.replace(pair.getKey(), sum);
        }
        return "0";
    }
    static int parseStr(String str){
        int minusMult = 0;
        int plusMult = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder(str);
        while (builder.toString().contains("*")){
            int indexStar = builder.indexOf("*");
            int indexSymbol1 = -1;
            // to right
            for (int j = indexStar + 2; j < builder.length(); j++) {
                if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-'
                        || builder.toString().charAt(j) == '*') {
                    indexSymbol1 = j;
                    break;
                } else {
                    indexSymbol1 = builder.length();
                }
            }
            // to left
            for (int j = indexStar - 2; j >=0; j--) {
                if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-' || builder.toString().charAt(j) == '*' || j==0) {
                    String val1 = builder.substring(j+1, indexStar);
                    String val2 = builder.substring(indexStar+1, indexSymbol1);
                    if (results.get(val1)==null || results.get(val2)==null) return -1;

                    if (builder.toString().charAt(j)== '-' && indexSymbol1 != -1) {
                        minusMult += results.get(val1) * results.get(val2);
                    }
                    else if (builder.toString().charAt(j) == '+' && indexSymbol1 != -1) {
                        plusMult += results.get(val1) * results.get(val2);
                    }
                    builder.delete(j, indexSymbol1);
                    break;
                }
            }
        }
        for (int i = builder.length()-1; i >=0; i--) {
            if (builder.toString().charAt(i) == '+' || i==0) {
                if (i == 0 && builder.length()!=0){
                    if (results.get(builder.toString()) == null) return -1;
                    sum += results.get(builder.toString());
                }else {
                    String val1 = builder.substring(i+1);
                    if (results.get(val1) == null) return -1;
                    sum += results.get(val1);
                    builder.delete(i, builder.length());
                }
            } else if(builder.toString().charAt(i) == '-'){
                String val1 = builder.substring(i+1);
                if (results.get(val1) == null) return -1;
                sum -= results.get(val1);
                builder.delete(i, builder.length());
            }
        }
        return sum+plusMult-minusMult;
    }
}