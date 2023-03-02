package Yandex.internWinter.D;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
//        ArrayList<int[]> list = new ArrayList<>();
        int[][] list = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
            list[i][2] = Integer.parseInt(input[2]);
        }

        int Q = Integer.parseInt(scanner.nextLine());
        int[] resultList = new int[Q];

        for (int i = 0; i < Q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int left  = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int type  = Integer.parseInt(input[2]);

            if (type == 2){ // где-то тут ошибка
                // Найти суммарную продолжительность заказов, которые завершились в заданный промежуток времени
//                int counter = 0;
                int result = 0;
                for (int j = 0; j < list.length; j++) {
                    int end = list[j][1];
                    if (left <= end && end <= right){
                        result += right - left;
//                        counter++;
                    }
                }
//                resultList[i] = (counter == 0 ? 0 : result/counter);
                resultList[i] = (result);
            } else {
                // Найти суммарную стоимость заказов, которые начались в заданный промежуток времени
                int result = 0;
                for (int j = 0; j < list.length; j++) {
                    int start = list[j][0], cost = list[j][2];
                    if (left <= start && start <= right){
                        result += cost;
                    }
                }
                resultList[i] = (result);
            }
        }

        String answer = "";
        for (int i = 0; i < resultList.length; i++){
            answer = answer + resultList[i];
            if (i != resultList.length - 1){
                answer = answer + " ";
            }
        }
        System.out.println(answer);
    }
}

//        5
//        5 20 5
//        6 21 4
//        6 22 3
//        7 23 2
//        10 24 1
