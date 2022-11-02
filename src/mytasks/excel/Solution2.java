package mytasks.excel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class    Solution2{

    static int minus = 0;
    static int plus = 0;
    static int sum = 0;

    static Map<String, Integer> results = new HashMap<>();
    static Map<String, String> formula = new HashMap<>();
    static Map<String, String[]> strings = new HashMap<>();
    static Map<String, Boolean> us = new HashMap<>();
    static ArrayList<String> path = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            String[] input = reader.readLine().split(" ");
            if (Integer.parseInt(input[0]) == 1) {
                int value = Integer.parseInt(input[1]);
                results.put("C" + i, value);
            } else {
                results.put("C" + i, null);
                formula.put("C" + i, input[1]);
            }
        }

        if (yeall()) { // вычисляется есть ли цикличномть в формулах
            System.out.println(-1);
        } else {
//            если цикличности нет, то выполняется следующая залупа
            for (int i = 1; i <= results.size(); i++) {
                    us.put("C" + i, false);
            }
            for (var v : strings.keySet()) {
                if (!us.get(v)) {
                    dfs(v);
                }
            }

            // в обратном порядке path считать для строк
            exe();
            printResult();
        }
    }
    static Integer parseStr(String str){
        minus = 0;
        plus = 0;
        sum = 0;
        StringBuilder builder = new StringBuilder(str);
        while (builder.toString().contains("*")){
            int star = builder.indexOf("*");
            int indexRight = -1;
            // to right
            for (int j = star + 2; j < builder.length(); j++) {
                if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-'
                        || builder.toString().charAt(j) == '*') {
                    indexRight = j;
                    break;
                } else {
                    indexRight = builder.length();    // где-то  тут ошибка.  -- напиздел
                }
            }
            // to left
            for (int indexLeft = star - 2; indexLeft >=0; indexLeft--) {
                if (builder.toString().charAt(indexLeft) == '+' || builder.toString().charAt(indexLeft) == '-' || builder.toString().charAt(indexLeft) == '*' || indexLeft==0) {
                    String val1 = builder.substring(indexLeft+1, star);
                    String val2 = builder.substring(star+1, indexRight);
                    if (builder.toString().charAt(indexLeft)== '-' && indexRight != -1) {
                        minus += results.get(val1) * results.get(val2);
                    }
                    else if (builder.toString().charAt(indexLeft) == '+' && indexRight != -1) {
                        plus += results.get(val1) * results.get(val2);
                    } else if (indexLeft==0) {
                        String val3 = builder.substring(indexLeft, star);
                        plus += results.get(val3) * results.get(val2);
                    }
                    builder.delete(indexLeft, indexRight);

                    if (builder.charAt(0) == '*'){
                        builder = method(builder);
                    }

                    break;
                }
            }
        }
        for (int i = builder.length()-1; i >=0; i--) {
            if (builder.toString().charAt(i) == '+' || i==0) {
                if (i == 0 && builder.length()!=0){
                    if (builder.charAt(i) == '+' ) {
                        String val = builder.substring(1);
                        sum += results.get(val);
                    } else if (builder.charAt(i) == '-' ){
                        String val = builder.substring(1);
                        sum -= results.get(val);
                    } else {
                        String val = builder.toString();
                        sum += results.get(val);
                    }
                }else {
                    String val1 = builder.substring(i+1);
                    sum += results.get(val1);
                    builder.delete(i, builder.length());
                }
            } else if(builder.toString().charAt(i) == '-'){
                String val1 = builder.substring(i+1);
                sum -= results.get(val1);
                builder.delete(i, builder.length());
            }
        }
        return sum + plus - minus;
    }

    static StringBuilder method(StringBuilder builder){
        int star = 0;
        int indexRight = 0;
        for (int j = star + 2; j < builder.length(); j++) {
            if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-'
                    || builder.toString().charAt(j) == '*') {
                indexRight = j;
                break;
            } else {
                indexRight = builder.length();    // где-то  тут ошибка.  -- напиздел
            }
        }

        String val = builder.substring(star+1,indexRight);
        int toMult = results.get(val);
        plus = plus * toMult;
        if (builder.charAt(0) == '+'){
            builder.delete(0, indexRight+1);
        }else {
            builder.delete(0, indexRight);
        }
        if (builder.charAt(0) == '*'){
            builder = method(builder);
        }
        return builder;
    }

    static void dfs(String s) {
        us.replace(s, true);
        if (results.get(s)== null) {
            for (var u : strings.get(s)) {
                if (!us.get(u)) {
                    dfs(u);
                }
            }
        }
        path.add(s);
    }

    static void exe(){
        for (int i = 0; i < results.size() ; i++) {
            String val = path.get(i);
            if (results.get(val)== null) {
                String strToParse = formula.get(val);
                int sum = parseStr(strToParse);
                results.replace(val, sum);
            }
        }
    }

    static void printResult(){
        for (int i = 1; i <= results.size(); i++) {
            System.out.println(results.get("C"+i));
        }
    }

    static boolean yeall(){
        for (var pair : formula.entrySet()) {
            String s = pair.getValue();
            String sIndex = pair.getKey();
            StringBuilder st = new StringBuilder();
            ArrayList<String> strings1 = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '-') {
                    strings1.add(st.toString());
                    st.delete(0, st.length());
                } else {
                    st.append(s.charAt(i));
                }
            }
            strings1.add(st.toString());
            st.delete(0, st.length());
            strings.put(sIndex, strings1.toArray(new String[strings1.size()]));
        }
        boolean yeall = false;
        for (var pair : strings.entrySet()) {
            String si = pair.getKey();
            String[] ss = pair.getValue();
            for (var s : ss) {
                String[] ss2 = strings.get(s);
                if (ss2 == null) {
                    continue;
                }
                for (int i = 0; i < ss2.length; i++) {
                    if (ss2[i].equals(si)) {
                        yeall = true;
                        break;
                    }
                }
            }
        }
        return yeall;
    }
}