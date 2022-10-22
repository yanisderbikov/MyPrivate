package mytasks.attractions.trash;

import java.util.HashMap;
import java.util.Scanner;

public class Solution3 {

    static HashMap<Integer, Integer> map1 = new HashMap<>();
    static HashMap<Integer, Integer> map2 = new HashMap<>();
    static HashMap<Integer, Integer> map3 = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(strings[0]);
        for (int i = 0; i < n1; i++) {
            int current = Integer.parseInt(strings[i]);
            map1.put(current, i);
        }

        strings = scanner.nextLine().split(" ");
        int n2 = Integer.parseInt(strings[0]);
        for (int i = 0; i < n2; i++) {
            int current = Integer.parseInt(strings[i]);
            map2.put(current, i);
        }

        strings = scanner.nextLine().split(" ");
        int n3 = Integer.parseInt(strings[0]);
        for (int i = 0; i < n3; i++) {
            int current = Integer.parseInt(strings[i]);
            map3.put(current, i);
        }

        for (int i = 0; i < n1; i++) {
            if (map2.containsKey(map1.get(i))){
                if (doesHaveNear(i) == -1){

                }
            }
        }

    }

    static void containNext() {

    }

    static int doesHaveNear(int i){
//        если имеется рядом, то вернуть какой элемент i+1 или i-1



        return 0;
    }
}
