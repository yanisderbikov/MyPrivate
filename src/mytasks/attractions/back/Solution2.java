package mytasks.attractions.back;

import java.util.*;

public class Solution2 {
    static Set<Integer> set = new HashSet<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(s[i + 1]);
            map.put(arr1[i],i);
        }

        s = scanner.nextLine().split(" ");
        int n2 = Integer.parseInt(s[0]);
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            int currentInteger = Integer.parseInt(s[i + 1]);
            arr2[i] = currentInteger;
            if (map.containsKey(currentInteger)){
                int index = map.get(currentInteger);
                for (int j = 0; j < n1; j++) {
                    
                }
            }


        }
    }

    static boolean isNext(){

        return true;
    }
}