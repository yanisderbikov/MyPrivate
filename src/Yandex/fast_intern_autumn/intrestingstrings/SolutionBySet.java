package Yandex.fast_intern_autumn.intrestingstrings;

import java.io.*;
import java.util.*;
// ошибка в скорости
public class SolutionBySet {
    static ArrayList<String> strings = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String currentLine = reader.readLine();
                strings.add(currentLine);
        }
        reader.close();


        int sum = 0;
        while (strings.size() != 1) {
            String currentStr = strings.get(0);
            for (int i = 1; i < strings.size(); i++) {  // почему стартуем с еденицы?
                int len = currentStr.length();          // потому что сравниваем сейчашнюю строку с след.
                int skips = 1;
                int theSame = len;
                String strToCompare = strings.get(i);
                for (int j = 0; j < strToCompare.length(); j++) {
//                        boolean isNotExistPair = back.containsKey(strToCompare) && back.get(strToCompare) != currentStr;

                    if (currentStr.charAt(j) != strToCompare.charAt(j) && skips == 1 ) {
                        len--;
                        skips--;
                    } else if (currentStr.charAt(j) == strToCompare.charAt(j) ) {
                        len--;
                        theSame--;
                    }
                }
                if (len == 0 && theSame != 0) {
                    sum++;
//                        back.put(strToCompare, currentStr);
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
