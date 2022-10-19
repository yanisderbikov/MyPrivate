package mytasks.intrestingstrings;

import java.util.*;

public class Solution {
    static ArrayList<String> strings = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            long startTime = System.currentTimeMillis();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            strings.add(scanner.nextLine());
        }

        int sum = 0;
        while (strings.size() != 1) {
            String currentStr = strings.get(0);
            for (int i = 1; i < strings.size(); i++) {
                int len = currentStr.length();
                int skips = 1;
                int theSame = len;
                String strToCompare = strings.get(i);
                for (int j = 0; j < strToCompare.length(); j++) {
                    if (currentStr.charAt(j) != strToCompare.charAt(j) && skips == 1) {
                        skips--;
                        len--;
                    }
                    if (currentStr.charAt(j) == strToCompare.charAt(j)) {
                        len--;
                        theSame--;
                    }
                }
                if (len == 0 && theSame != 0){
                    sum++;
                }
            }
            strings.remove(0);
        }
        System.out.println(sum);

            long time = System.currentTimeMillis() - startTime;
            System.out.println("время выполнения:" + time);


    }
}
