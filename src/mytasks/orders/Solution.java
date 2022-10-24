package mytasks.orders;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    static Map<int[], Integer> coordinates = new TreeMap<>(Arrays::compare);
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int     N = Integer.parseInt(input[0]),
                M = Integer.parseInt(input[1]),
                R = Integer.parseInt(input[2]);

        for (int i = 1; i <= N; i++) {
            String[] input2 = reader.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                int d = Integer.parseInt(input2[j-1]);
                coordinates.put(new int[]{i, j}, d);
            }
        }
        reader.close();
        int max = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                max = Math.max(max, findCountAtRC(R, r, c));
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(max));
        writer.flush();
        writer.close();
    }

    static int findCountAtRC(int R, int r, int c){

        int count = 0;
        for (int i = r - R; i <= r + R; i++) {
            if (i <= 1) i = 1;
            for (int j = c - R; j <= c + R; j++) {
                if (j <= 1) j = 1;
                int[] arr = new int[]{i,j};
                if (coordinates.containsKey(arr) &&
                        (Math.pow((i - r), 2) + Math.pow((j - c), 2)) <= Math.pow(R, 2)
                ){
                    count += coordinates.get(arr);
                }
            }
        }
        return count;
    }
}
