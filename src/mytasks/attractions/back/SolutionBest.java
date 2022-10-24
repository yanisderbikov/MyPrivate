package mytasks.attractions.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionBest {

       static ArrayList<Integer> arrayList = new ArrayList<>();
       static ArrayList<Integer> str2 = new ArrayList<>();



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(s[i+1]);

        }

        s = scanner.nextLine().split(" ");
        int n2 = Integer.parseInt(s[0]);
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(s[i+1]);

            if (Arrays.equals(
                    Arrays.copyOfRange(arr1, arr1.length-i, arr1.length),
                    Arrays.copyOfRange(arr2, i, (arr1.length - (arr1.length - i)))
            )){
                if (Arrays.equals(Arrays.copyOfRange(arr1, arr1.length-i, arr1.length), arr1)){
                    addToArrayList(arr1, Arrays.copyOfRange(arr2, i, (arr1.length - (arr1.length - i))) );
                } else {
                    addToArrayList(Arrays.copyOfRange(arr1, arr1.length - i, arr1.length), Arrays.copyOfRange(arr2, i, (arr1.length - (arr1.length - i))));
                }
            }

        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }




    }
    static void addToArrayList(int[] arr1 , int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            arrayList.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            arrayList.add(arr2[i]);
        }
    }
//        int[] arr2 = new int[7];
//        int n = 3;  // должно быть парсинг строк
//        for (int i = 0; i < n; i++) {
//            int len = arr1.length;
//            if (Arrays.equals(Arrays.copyOfRange(arr1, arr1.length-i, arr1.length), Arrays.copyOfRange(arr2, i, arr2.length-i))){
////                SAVE            }
//        }
//    }

}
