package Yandex.internWinter.D;

import java.util.*;

public class Solution_binarySearch {
    static int result_global = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
//        ArrayList<int[]> list = new ArrayList<>();

//        long time_code = System.currentTimeMillis();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();


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

        int[] nums_map1 = new int[map1.size()];
        int[] nums_map2 = new int[map2.size()];

        int j = 0;
        for (int num : map1.keySet()){
            nums_map1[j++] = num;
        }

        j = 0;
        for (int num : map2.keySet()) {
            nums_map2[j++] = num;
        }

        Arrays.sort(nums_map1);
        Arrays.sort(nums_map2);


        String answer = "";
        for (int i = 0; i < Q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int type = Integer.parseInt(input[2]);

            result_global = 0;
            int result = 0;
            if (type == 1) {
                // нужно отобрать в интервале
                for (int num : binarySearch(nums_map1, left, right)){
                    result += map1.get(num);
                }
            } else {
                for (int num : binarySearch(nums_map2, left, right)){
                    result += map2.get(num);
                }
            }
//            answer = answer + result_global + " ";
            answer = answer + result + " ";
        }

        System.out.println(answer);
        //    System.out.println("---------------------------------");
//        System.out.println(System.currentTimeMillis() - time_code);
    }

    static List<Integer> binarySearch(int[] nums, int l_board, int r_board){
        // вернуть все элементы, которые нужны
        int from = binaryLeft(nums, l_board);
        int to = binaryRight(nums, r_board);
        List<Integer> list = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    static int binaryLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int midpoint = left + (right - left) /2;
            if (target == nums[midpoint]) return midpoint;
            if (target > nums[midpoint]){
                left = midpoint + 1;
            }else {
                right = midpoint - 1;
            }
        }
        return left;
    }
    static int binaryRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int midpoint = left + (right - left) /2;
            if (target == nums[midpoint]) return midpoint;
            if (target > nums[midpoint]){
                left = midpoint + 1;
            }else {
                right = midpoint - 1;
            }
        }
        return right;
    }

}
