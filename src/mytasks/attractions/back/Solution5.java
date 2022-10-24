package mytasks.attractions.back;

import java.util.HashMap;
import java.util.Scanner;

public class Solution5 {
    static HashMap<String, Integer> map2at1 = new HashMap<>();
    static HashMap<String, Integer> map3at1 = new HashMap<>();

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        StringBuilder builder1 = new StringBuilder(str1[1]);
        for (int i = 0; i < Integer.parseInt(str1[0]); i++) {
            builder1.append(" " + str1[i]);
        }
        String[] str2 = scanner.nextLine().split(" ");
        StringBuilder builder2 = new StringBuilder(str1[1]);
        for (int i = 0; i < Integer.parseInt(str2[0]); i++) {
            if (builder1.toString().contains(builder2.toString())) {
                map2at1.put(builder2.toString(), i);
            }
            builder2.append(" " + str2[i]);
        }
        if (map2at1.isEmpty()){
            builder1.append(builder2);
        }


        String[] str3 = scanner.nextLine().split(" ");
        StringBuilder builder3 = new StringBuilder(str1[1]);
        for (int i = 0; i < Integer.parseInt(str3[0]); i++) {
            if (builder1.toString().contains(builder3.toString())){
//                map3at1.put();
            }
        }





    }


}
