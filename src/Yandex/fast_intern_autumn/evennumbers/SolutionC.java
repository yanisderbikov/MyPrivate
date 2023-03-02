package Yandex.fast_intern_autumn.evennumbers;

import java.io.*;

public class SolutionC {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrInput = reader.readLine().split(" ");
        int n = Integer.parseInt(arrInput[0]);          // k <= n
        int k = Integer.parseInt(arrInput[1]);

        int[] a = new int[n];
        int[] b = new int[n];

        String[] input = reader.readLine().split(" ");
        int chet = 0, allСhet = 0;

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
            if (Math.abs(a[i]) % 2 == 0){
                b[i] = 1;
                allСhet++;
            }
        }
        int l = 0, ans = 0;
        for (int r = 0; r < n; r++) {
            chet += b[r];
            while (l < r && (r - l + 1) - chet > k){
                chet -= b[l];
                l++;
            }
            ans = Math.max(r - l + 1, ans);
        }
        String answerStr = String.valueOf(Math.min(allСhet, ans));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(answerStr);
        writer.close();
//        System.out.println(Math.min(allСhet, ans));
    }
}
