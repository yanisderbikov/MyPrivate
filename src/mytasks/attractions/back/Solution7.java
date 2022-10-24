package mytasks.attractions.back;

import java.util.*;

public class Solution7 {

//    static Map<Integer, Integer> map = new HashMap<>();
//    static List<Integer> list = new ArrayList<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> cash = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input  = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);

        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(input[i+1]));
        }
//        2 element
        input = scanner.nextLine().split(" ");
        creation(input);

        input = scanner.nextLine().split(" ");
        creation(input);

        for (int e : arrayList) System.out.print(e + " ");
    }



    static void creation(String[] input){
        int n = Integer.parseInt(input[0]);
        int indexOfLast = -1;
        boolean isExecuted = false;
        for (int i = 0; i < n; i++) {
            int currentInt = Integer.parseInt(input[i+1]);

            if (i == 0 && arrayList.contains(currentInt)){
                indexOfLast = arrayList.indexOf(currentInt) - 1;
            }

            if (arrayList.contains(currentInt)){
                int indexOfCurrentInt = arrayList.indexOf(currentInt);
                if (indexOfCurrentInt == arrayList.size()-1 && i == 0){ // if index the last of 1st string
                    for (int j = 0; j < n; j++) {
                        int ci = Integer.parseInt(input[j+1]);
                        if (j != 0)
                            arrayList.add(ci);
                    }
                    isExecuted = true;
                    break;
                } // if the last
                if (indexOfCurrentInt == 0 && i == n - 1){
                    for (int j = 0; j < n ; j++) {
                        int ci = Integer.parseInt(input[j+1]);
                        arrayList.add(0, ci);
                    }
                    isExecuted = true;
                    break;
                } // if the first
                if (indexOfLast + 1 == indexOfCurrentInt || indexOfCurrentInt == 0){ // дописать условия
                    indexOfLast = indexOfCurrentInt;

                }
            }
            cash.add(currentInt);
        }
        if (!isExecuted){
            arrayList.addAll(cash);
            cash.clear();
        }

    }


}
