package Yandex.internWinter.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static HashMap<Integer, HashMap<MyDate, Character>> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            parser(scanner.nextLine());
        }

//        должны выводиться в порядке возрастания индификатора ракет
        int s = map.keySet().size();

        ArrayList<Integer> list = new ArrayList<>();

        for (var a : map.keySet()){
            list.add(a);
        }

        Collections.sort(list);

        String out = "";
        for (int i = 0; i < list.size(); i++) {
            out = out + output(map.get(list.get(i))) + " ";
        }
        System.out.println(out.substring(0, out.length() - 1));

//        long finish = System.currentTimeMillis();
//        long elapsed = finish - start;
//        System.out.println("Прошло времени, мс: " + elapsed);

    }
    static void parser(String str){
        String input[] = str.split(" ");
        MyDate date = new MyDate(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        int id = Integer.parseInt(input[3]);
        char status = input[4].charAt(0);

        if (map.containsKey(id)){
            HashMap<MyDate, Character> innerMap = map.get(id);
            innerMap.put(date, status);
        } else {
            HashMap<MyDate, Character> innerMap = new HashMap<>();
            innerMap.put(date, status);
            map.put(id, innerMap);
        }
    }

    static String output(HashMap<MyDate, Character> hashMap){
        // выписать MyDate и сделать сортировку
        ArrayList<MyDate> list = new ArrayList<>();

        for (MyDate date : hashMap.keySet()){
            list.add(date);
        }

        Collections.sort(list);

        int res = -1;
        int output = 0;
        for (int i = 0; i < list.size(); i++) {
            if (hashMap.get(list.get(i)) == 'C' || hashMap.get(list.get(i)) == 'S'){
                res = i;
            } else if (hashMap.get(list.get(i)) == 'A'){
                MyDate date1 = list.get(res);
                MyDate date2 = list.get(i);
                output += date1.minus(date2);
            }
        }
        return String.valueOf(output);
    }


    public static class MyDate implements Comparable<MyDate> {
        private int day;
        private int hour;
        private int minute;

        public MyDate(int day, int hour, int minute) {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
        }

        public int getDay() {
            return day;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public long minus(MyDate d2){
//        if (!this.isGreater(d2)) return -1;

            int d = day - d2.getDay();
            int h = hour - d2.getHour();
            int m = minute - d2.getMinute();

            return (long) d * 24 * 60 + h * 60L + m;
        }

        @Override
        public int compareTo(MyDate o) {
            return (o.getDay() - this.getDay()) * 24 * 60  + (o.getHour() - this.getHour()) * 60 + o.getMinute() - this.minute;
        }
    }

}
