package mytasks.attractions;

import java.util.*;

public class Solution {

    static ArrayList<int[]> list = new ArrayList<>();
    static List<Integer> way = new ArrayList<>();

    public static void main(String[] args) {
        parse();
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < list.size(); i++) {
            int[] current = list.get(i);
            int[] corrected = check(current);
            addToWay(corrected);
        }

        System.out.println(way.size());
        System.out.println(printWay());
    }

    static void parse(){
        Scanner scanner = new Scanner(System.in);
//        3 стоочки
        for (int i = 0; i < 3; i++) {
            String[] strings = scanner.nextLine().split(" ");
            int amount = Integer.parseInt(strings[0]);
            int[] line = new int[amount];
            for (int j = 0; j < amount; j++) {
                line[j] = Integer.parseInt(strings[j+1]);
            }
            list.add(line);
        }
    }

    static int[] check(int[] current){
        if (way.contains(current[0])){
            int index = way.indexOf(current[0]);
            int indexFromDelete = 0;
            for (int i = 0; i < current.length; i++) {
//                check exception at get(index + i)
                if (index + i < way.size()) {
                    if (way.get(index + i) == current[i]) {
                        indexFromDelete++;
                    } else {
                        i = Integer.MAX_VALUE;
                    }
                }
            }
            return Arrays.copyOfRange(current, indexFromDelete, current.length);
        }
        return current;
    }

    static void addToWay(int[] corrected){
        for (int i = 0; i < corrected.length; i++) {
            way.add(corrected[i]);
        }
    }

    static String printWay(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < way.size(); i++) {
            builder.append(way.get(i));
            builder.append(" ");
        }
        return builder.substring(0,builder.length()-2);
    }
}
