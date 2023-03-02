package Yandex._2023.Spring_Summer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] input2 = reader.readLine().split(" ");
        String[] input3 = reader.readLine().split(" ");
        int K = Integer.parseInt(reader.readLine());
        String[] input5 = reader.readLine().split(" ");


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input2[i]);
            int row = Integer.parseInt(input3[i]);
            map.put(num, row);
        }

        int counter = 0;
        int lastRow = map.get(Integer.parseInt(input5[0])); // задем прошедший элемент как первый, чтобы не было прибавления
        for (int i = 0; i < K; i++) {
            int cur = Integer.parseInt(input5[i]);
            if (map.get(cur) != lastRow){
                lastRow = map.get(cur);
                counter++;
            }
        }

        System.out.println(counter);

    }
}
