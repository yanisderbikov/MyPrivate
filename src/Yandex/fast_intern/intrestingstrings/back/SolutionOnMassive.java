package Yandex.fast_intern.intrestingstrings.back;

import java.io.*;
import java.util.ArrayList;

public class SolutionOnMassive {
    static ArrayList<String> massive = new ArrayList<>();
    static ArrayList<Integer> mountOfSkips = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String currentLine = reader.readLine();
            strings[i] = currentLine;
        }



        int result = 0;
        int stringLength = strings[0].length();

        for (int i = 0; i < stringLength; ++i) {
            String current = strings[i];



        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
        reader.close();

    }
}

