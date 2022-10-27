package mytasks.excel;

import java.util.Scanner;

import java.util.*;


public class    Solution2{
    static Map<String, Integer> results = new HashMap<>();
    static Map<String, String> formula = new HashMap<>();
    static Map<String, String[]> strings = new HashMap<>();
    static Map<String, Boolean> us = new HashMap<>();
    static ArrayList<String> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (Integer.parseInt(input[0]) == 1) {
                int value = Integer.parseInt(input[1]);
                results.put("C" + i, value);
            } else {
                results.put("C" + i, null);
                formula.put("C" + i, input[1]);
            }
        }
        for (var pair : formula.entrySet()) {
            String s = pair.getValue();
            String sIndex = pair.getKey();
            StringBuilder st = new StringBuilder();
            //System.out.println(s);
            ArrayList<String> strings1 = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '-') {
                    strings1.add(st.toString());
                    //System.out.println(st.toString());
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

        if (yeall) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= results.size(); i++) {
//                if (strings.containsKey("C"+i)) {
//                if (v)
                    us.put("C" + i, false);
//                }
            }
            for(var v : strings.keySet()) {
                if(!us.get(v)) {
                    dfs(v);
                }
            }
//            System.out.println();
            // в обратном порядке path считать для строк
            exe();
            printResult();
        }
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

    static Integer parseStr(String str){
        int minusMult = 0;
        int plusMult = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder(str);/////
        while (builder.toString().contains("*")){
            int indexStar = builder.indexOf("*");
            int indexSymbol1 = -1;
            // to right
            for (int j = indexStar + 2; j < builder.length(); j++) {
                if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-'
                        || builder.toString().charAt(j) == '*') {
                    indexSymbol1 = j;
                    break;
                } else {
                    indexSymbol1 = builder.length();
                }
            }
            // to left
            for (int j = indexStar - 2; j >=0; j--) {
                if (builder.toString().charAt(j) == '+' || builder.toString().charAt(j) == '-' || builder.toString().charAt(j) == '*' || j==0) {
                    String val1 = builder.substring(j+1, indexStar);
                    String val2 = builder.substring(indexStar+1, indexSymbol1);
//                    if (results.get(val1)==null) ece(val1);
//                    if (results.get(val2)==null) ece(val2);
                    if (builder.toString().charAt(j)== '-' && indexSymbol1 != -1) {
                        minusMult += results.get(val1) * results.get(val2);
                    }
                    else if (builder.toString().charAt(j) == '+' && indexSymbol1 != -1) {
                        plusMult += results.get(val1) * results.get(val2);
                    } else if (j==0) {
                        String val3 = builder.substring(j, indexStar);
//                        if (results.get(val3)==null) ece(val3);
                        plusMult += results.get(val3) * results.get(val2);
                    }
                    builder.delete(j, indexSymbol1);
                    break;
                }
            }
        }
        for (int i = builder.length()-1; i >=0; i--) {
            if (builder.toString().charAt(i) == '+' || i==0) {
                if (i == 0 && builder.length()!=0){
                    if (builder.charAt(i) == '+' ) {
                        String val = builder.substring(1);
//                        if (results.get(val) == null) ece(val);
                        sum += results.get(val);
                    } else if (builder.charAt(i) == '-' ){
                        String val = builder.substring(1);
//                        if (results.get(val) == null) ece(val);
                        sum -= results.get(val);
                    } else {
                        String val = builder.toString();
//                        if (results.get(val) == null) ece(val);
                        sum += results.get(val);
                    }
                }else {
                    String val1 = builder.substring(i+1);
//                    if (results.get(val1) == null) ece(val1);
                    sum += results.get(val1);
                    builder.delete(i, builder.length());
                }
            } else if(builder.toString().charAt(i) == '-'){
                String val1 = builder.substring(i+1);
//                if (results.get(val1) == null) ece(val1);
                sum -= results.get(val1);
                builder.delete(i, builder.length());
            }
        }
      /*  if (builder.length() != 0){
            sum += results.get(builder.toString());
        }*/
        return sum+plusMult-minusMult;
    }
    static void ece(String val) {
        Integer ecee = parseStr(formula.get(val));
        results.replace(val, ecee);

    }
}