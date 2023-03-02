package Yandex.offerNik_conest.coordinates;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static HashMap<Integer, Integer>  map = new HashMap<>();
    static HashMap<Integer[], Integer> counterOrder = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int s = Integer.parseInt(strArr[1]);

//        записываем данные
        for (int i = 0; i < n; i++) {
            String[] str = scanner.nextLine().split(" ");
            map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }


//        итерируемся по площади
        long count = 0;
        for (double i = 0; i < s; i += 0.5) {

            double x = i, y = s - i;

             checker(x,y);


        }


    }

    static void checker(double x, double y){

         map.entrySet().stream()
                .filter(e -> {
                    if (e.getKey() < x && e.getValue() < y){
                        return true;
                    }
                    return false;
                })
                .forEach(e -> counterOrder.put(new Integer[]{e.getKey(), e.getValue()} , +1));



    }



}
