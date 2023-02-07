package Yandex.fast_intern.intrestingstrings.back;

import java.io.*;
import java.util.*;

public class SolutionV2 {
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String currentLine = reader.readLine();
            if (!strings.contains(currentLine)) {
                strings.add(currentLine);
            }
        }
        int result = 0;
        int arraySize = strings.size();
        int stringLength = strings.get(0).length();

        for (int i = 0; i < arraySize - 1; ++i) {
            for (int j = i + 1; j < arraySize; ++j) {
                String s1 = strings.get(i);
                String s2 = strings.get(j);
                int diff = 0;
                if (s1.equals(s2)) {
                    continue;
                }
                for (int chIndex = 0; chIndex < stringLength; chIndex++) {
                    if (s1.charAt(chIndex) != s2.charAt(chIndex)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    result++;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
        reader.close();

    }
}