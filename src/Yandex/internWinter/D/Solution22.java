package Yandex.internWinter.D;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution22 {
    static int result_global = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
//        ArrayList<int[]> list = new ArrayList<>();

//        long time_code = System.currentTimeMillis();

        SortedMap<Integer, Integer> map1 = new TreeMap<>();
        SortedMap<Integer, Integer> map2 = new TreeMap<>();


        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

// 1. Найти суммарную стоимость заказов, которые начались в заданный промежуток времени;
            if (map1.containsKey(start)) {
                cost += map1.get(start);
            }
            map1.put(start, cost);

// 2. Найти суммарную продолжительность заказов, которые завершились в заданный промежуток времени;
            if (map2.containsKey(end)) {
                int time = map2.get(end);
                int res = time + end - start;
                map2.put(end, res);
            } else {
                map2.put(end, end - start);
            }
        }

        int Q = Integer.parseInt(scanner.nextLine());

        String answer = "";
        for (int i = 0; i < Q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int type = Integer.parseInt(input[2]);

            result_global = 0;
            if (type == 1) {
                // нужно отобрать в интервале
                map1.entrySet().stream()
                        .filter(x -> left <= x.getKey() && x.getKey() <= right)
                        .forEach(e -> result_global = result_global + e.getValue());


            } else {
                map2.entrySet().stream()
                        .filter(x -> left <= x.getKey() && x.getKey() <= right)
                        .forEach(e -> result_global = result_global + e.getValue());

            }
            answer = answer + result_global + " ";
        }

        System.out.println(answer);
    //    System.out.println("---------------------------------");
//        System.out.println(System.currentTimeMillis() - time_code);
    }
}

