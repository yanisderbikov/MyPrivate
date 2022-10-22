package mytasks.excel.trash;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class Solution {
    static Map<Integer, String> formulas = new HashMap<>();
    static Map<Integer, Integer> results = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (Integer.parseInt(input[0])==1){
                int value = Integer.parseInt(input[1]);
                results.put(i, value);
            } else {
                formulas.put(i, input[1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!results.containsKey(i)){
                int br = parseFormula(i);
                if (br == -1){
                    System.out.println(br);
                    break;
                }
            }
            System.out.println(results.get(i));
        }
    }

    // TODO: 17.10.2022 функция должна по индексу 'i' взять из formulas взять строку с формулой
    //  произвести над ней все операции, которые сказаны в формуле
    //  значение положить в results под индексом 'i'


    // TODO: 17.10.2022 при умножении / делении
    static int parseFormula(int i) {
        Map<Integer, Double> values = new HashMap<>();
        Map<int[], Character> operations = new TreeMap<>(Arrays::compare);
        String formula = formulas.get(i);
        StringBuilder builder = new StringBuilder(formula);
        for (int j = 2; j < builder.length(); j++) {
            Character currentChar1 = builder.charAt(j);

            if (j == builder.length() - 1){
                for (int k = 2; k < builder.length(); k++) {
                    currentChar1 = builder.charAt(k);
                    if (currentChar1.equals('*') || currentChar1.equals('+') || currentChar1.equals('-')){
                        int ind1 = Integer.parseInt(builder.substring(1, k));
                        int ind2 = Integer.parseInt(builder.substring(k + 2, builder.length()));
                        if (currentChar1.equals('*')){
                            double d = (double)results.get(ind1)* (double) results.get(ind2);
                            values.put(ind1, d/2);
                            values.put(ind2, d/2);
                            operations.put(new int[]{ind1, ind2}, '+');
                        } else { // есть ошибка при использовании одинаковых индексов. А может и не ошибка
                            values.put(ind1, (double) results.get(ind1));
                            values.put(ind2, (double) results.get(ind2));
                            operations.put(new int[]{ind1, ind2}, currentChar1);
                        }
                        k += builder.length();
                        builder.delete(0,j+1);
                        j=1;
                    }
                }
            } else if (currentChar1.equals('*') || currentChar1.equals('+') || currentChar1.equals('-')) {

                for (int k = j + 3; k < builder.length(); k++) {
                    Character currentChar2 = builder.charAt(j);
                    if (currentChar2.equals('*') || currentChar2.equals('+') || currentChar2.equals('-')) {
//                        тут нужно взять индексы
                        int ind1 = Integer.parseInt(builder.substring(1, j));
                        int ind2 = Integer.parseInt(builder.substring(j + 2, k));

                        if (!results.containsKey(ind1) || !results.containsKey(ind2)) {
                            return -1;
                        }

                        if (currentChar1.equals('*')){
                            double d = (double)results.get(ind1)* (double) results.get(ind2);
                            values.put(ind1, d/2);
                            values.put(ind2, d/2);
                            operations.put(new int[]{ind1, ind2}, '+');
                        } else { // есть ошибка при использовании одинаковых индексов. А может и не ошибка
                            values.put(ind1, (double) results.get(ind1));
                            values.put(ind2, (double) results.get(ind2));
                            operations.put(new int[]{ind1, ind2}, currentChar1);
                        }
                        k += builder.length();
                        builder.delete(0,j+1);
                        j=1;
                    }
                }
            }
        }
        while (operations.containsValue('-')){
            for (var pair : operations.entrySet()){
                if (pair.getValue().equals('-')){
                    int[] n = pair.getKey();
                    values.replace(n[1], -values.get(n[1]));
                }
            }
        }

        double result = 0;
        for (var pair : values.values()){
            result += pair;
        }

        results.put(i, (int) result);

        return 0;
    }
}
