package Yandex.fast_intern_autumn.attractions.back;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution71 {


//    static Map<Integer, Integer> map = new HashMap<>();
//    static List<Integer> list = new ArrayList<>();
        static ArrayList<Integer> way = new ArrayList<>();


        public static void main(String[] args) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            ArrayList<Integer> arrayList3 = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            String[] input  = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);

            for (int i = 0; i < n; i++) {
                way.add(Integer.parseInt(input[i+1]));
            }

//            2nd element
            input = scanner.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(input[0]); i++) {
                arrayList2.add(Integer.parseInt(input[i+1]));
            }


//            3rd element
            input = scanner.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(input[0]); i++) {
                arrayList3.add(Integer.parseInt(input[i+1]));
            }

//            в какой последовательности выполнять
            if (arrayList2.get(0) < arrayList3.get(0) ){
                creation(arrayList2);
                creation(arrayList3);
            } else {
                creation(arrayList3);
                creation(arrayList2);
            }
            for (int e : way) System.out.print(e + " ");
        }


    // TODO: 21.10.2022 сделать проверку. Если не получилось сделать
        static void creation(ArrayList<Integer> arrayList){
            ArrayList<Integer> cash = new ArrayList<>();

            int n = arrayList.size();
            int indexOfLast = -1;
            boolean isExecuted = true;

            if (true){
//                way.indexOf(arrayList.get(arrayList.size()-1))
//              put arrayList between that two nums
                for (int i = 0; i < n; i++) {
                    way.add(arrayList.get(i));
                }


            }if (way.get(way.size()-1) == arrayList.get(0)){ //последний объект
                for (int i = 0; i < n; i++) {
                    if (i != 0)
                        way.add(arrayList.get(i));
                }
            }else
                if (way.get(0) == arrayList.get(n-1)){ // первый елемент
                Collections.reverse(arrayList);
                for (int i = 0; i < n; i++) {
                    if (i != 0)
                        way.add(0, arrayList.get(i));
                }
            }
            else if (isExecuted){
//                сперерди идем и смотрим массив на сколько его можно запихнуть
                int index;
                int counter = 0;
                for (int i = 0; i < n; i++) {
                    int currentInt = arrayList.get(i);
                    if (way.contains(currentInt)){
                        index = way.indexOf(currentInt);
                        if (index - counter == index - i){
                            counter++;
                        } else{
                            break;
                        }
                    }
                }
//                тут можно оптимизировать если сработает
                for (int i = counter; i < n - counter; i++) {
                    way.add(arrayList.get(i));
                }
                isExecuted = false;
            }
            if (isExecuted){
//                сделать чтобы чекалось с конца
                int index;
                int counter = 0;
                for (int i = n-1; i >= 0; i++) {
                    int currentInt = arrayList.get(i);
                    if (way.contains(currentInt)){
                        index = way.indexOf(currentInt);
                        if (counter ==i){
                            counter++;
                        } else{
                            break;
                        }
                    }
                }
//                тут можно оптимизировать если сработает
                for (int i = 0; i < counter + 1; i++) {
                    way.add(arrayList.get(i));
                }
            }
        }
}

