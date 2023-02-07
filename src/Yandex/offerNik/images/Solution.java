package Yandex.offerNik.images;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String strW = scanner.nextLine();
        int w = Integer.parseInt(strW);
        String string = scanner.nextLine();
        String[] str = string.split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] arrS = s.split("x");
            int w_ = Integer.parseInt(arrS[0]);
            int h_ = Integer.parseInt(arrS[1]);

            int h = (int) Math.ceil(((double)h_*(double)w)/(double)w_);
            arrayList.add(h);
        }
        arrayList.sort(Integer::compare);
        int resultMin = 0, resultMax = 0;
        for (int i = 0; i < k; i++) {
            resultMin += arrayList.get(i);
            resultMax += arrayList.get(arrayList.size() - 1 - i);
        }
        System.out.println(resultMin);
        System.out.println(resultMax);
    }
}
