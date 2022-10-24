package mytasks.orders.back;

import java.util.*;

public class Solution {

    static Map<int[], Integer> map = new TreeMap<>(Arrays::compare);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        отсканить 3 переменные
        String str = scanner.nextLine();
        String[] argStr = str.split(" ");
        long startTime = System.currentTimeMillis();
        int N = Integer.parseInt(argStr[0]), M = Integer.parseInt(argStr[1]), R = Integer.parseInt(argStr[2]);
        for (int i = 0; i < N; i++) {
            str = scanner.nextLine();
            argStr = str.split(" ");
            for (int j = 0; j < M; j++) {
//                пробегаемся по первой строке
                int d = Integer.parseInt(argStr[j]);
//                для этого d мы ищем все r и с, которые подойдут по условию
                for (int r = 0; r < M - R + 1; r++) {
                    for (int c = 0; c < N - R + 1; c++) {
                        boolean bool = (Math.pow((i - r), 2) + Math.pow((j - c), 2) <= Math.pow(R,2));
                        if (bool){
                            int[] arr = new int[]{r, c};
                            if (map.containsKey(arr)){
                                int dInner = map.get(arr);
                                d = d + dInner;
                                map.replace(arr, d);
                            } else {
                                map.put(arr, d);
                            }
                        }
                    }
                }
            }
        }

        int result = map.values().stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(result);
        long time = System.currentTimeMillis() - startTime;
        System.out.println("время выполнения:" + time);

    }
}
