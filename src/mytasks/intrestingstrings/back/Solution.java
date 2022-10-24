package mytasks.intrestingstrings.back;

import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<String> strings = new ArrayList<>();
    static Map<String, String> back = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            strings.add(reader.readLine());
        }
        reader.close();

        // TODO: 24.10.2022 подумать! если строки повторяются, то они не должны считаться

        int sum = 0;
        while (strings.size() != 1) {
            String currentStr = strings.get(0);
            for (int i = 1; i < strings.size(); i++) {  // почему стартуем с еденицы?
                int len = currentStr.length();          // потому что сравниваем сейчашнюю строку с след.
                int skips = 1;
                int theSame = len;
                String strToCompare = strings.get(i);
                if (!currentStr.equals(strToCompare)) {
                    for (int j = 0; j < strToCompare.length(); j++) {
                        boolean isNotExistPair = back.containsKey(strToCompare) && back.get(strToCompare) != currentStr;

                        if (currentStr.charAt(j) != strToCompare.charAt(j) && skips == 1 && !isNotExistPair) {
                            len--;
                            skips--;
                        } else if (currentStr.charAt(j) == strToCompare.charAt(j) && !isNotExistPair) {
                            len--;
                            theSame--;
                        }
                    }
                    if (len == 0 && theSame != 0) {
                        sum++;
                        back.put(strToCompare, currentStr);
                    }
                }
            }
            strings.remove(0);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(sum));
        writer.flush();
        writer.close();

    }
}
