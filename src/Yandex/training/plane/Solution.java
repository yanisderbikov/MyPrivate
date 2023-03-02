package Yandex.training.plane;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static HashMap<Integer, Integer[]> seatsR = new HashMap<>();
    static HashMap<Integer, Integer[]> seatsL = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Adding rows to HashMap seats
        int rows = scanner.nextInt();
        for (int i = 0; i < rows; i++) {
            String lineRow = scanner.nextLine();
            Integer[][] row = parseStringRow(lineRow);
            seatsL.put(i, row[0]);
            seatsR.put(i, row[1]);
        }
//        seating peoples to seats
        int amountPassengers = scanner.nextInt();
        for (int i = 0; i < amountPassengers; i++) {
            String[] str = scanner.nextLine().split(" ");
            Integer[] passengersSeats = howWantToSeat(str);
            if (str[1].equals("left")){
                takeSeatsL(passengersSeats);
            } else {
                takeSeatsR(passengersSeats);
            }

        }




    }

    static void takeSeatsR(Integer[] passengersSeats){

        if (seatsR.containsValue(passengersSeats)){
            seatsR.entrySet().stream()
                    .filter(x -> Arrays.equals(x.getValue(), passengersSeats))
                    .map(Map.Entry::getKey)
                    .min(Integer::compare)
                    .ifPresent(row -> seatsR.replace(row, passengersSeats));



        } else {
            System.out.println("Cannot fulfill passengers requirements.");
        }
    }

    static void takeSeatsL(Integer[] passengersSeats){

        if (seatsL.containsValue(passengersSeats)){
            seatsL.entrySet().stream()
                    .filter(x -> Arrays.equals(x.getValue(), passengersSeats))
                    .map(Map.Entry::getKey)
                    .min(Integer::compare)
                    .ifPresent(row -> seatsL.replace(row, passengersSeats));
        } else {
            System.out.println("Cannot fulfill passengers requirements.");
        }
    }

    static Integer[][] parseStringRow(String lineRow){

        int[] row = new int[6];
        for (int i = 0; i < lineRow.length(); i++) {
            Character currentChar = lineRow.charAt(i);
            if (currentChar.equals('.')){
                row[i] = 0;
            } else if (currentChar.equals('#')) {
                row[i] = 1;
            }
        }
        return new Integer[][]{{row[0], row[1], row[2]},{row[3], row[4], row[5]}};
    }

    static Integer[] howWantToSeat(String[] str){
        int amountOfPassengers = Integer.parseInt(str[0]);
        String windowOrAisle = str[2];
        String leftOrRight = str[1];

        if (amountOfPassengers == 3){
            return new Integer[]{1,1,1};
        }

        else if (amountOfPassengers == 2) {
            if (leftOrRight.equals("left")){
                if (windowOrAisle.equals("window")){
                    return new Integer[]{1,1,0};
                } else {
                    return new Integer[]{0,1,1};
                }
            }
            else {
                if (windowOrAisle.equals("window")){
                    return new Integer[]{0,1,1};
                } else {
                    return new Integer[]{1,1,0};
                }
            }

        }

        else {
            if (leftOrRight.equals("left")){
                if (windowOrAisle.equals("window")){
                    return new Integer[]{1,0,0};
                } else {
                    return new Integer[]{0,0,1};
                }
            }
            else {
                if (windowOrAisle.equals("window")){
                    return new Integer[]{0,0,1};
                } else {
                    return new Integer[]{1,0,0};
                }
            }
        }
    }

    static String parseBack(int atRow){
        Integer[] r = seatsR.get(atRow);
        Integer[] l = seatsL.get(atRow);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i <= 2) {
                builder.append(add(l[i]));
            } else {
                builder.append(add(r[i]));
            }
        }
        builder.insert(3,'_');
        return builder.toString();
    }
    static Character add(Integer n){
        Character nowSeatingAt = 'X';
        Character took = '#';
        Character empty = '.';
        if (n == 0){
            return empty;
        } else if (n == 1) {
            return took;
        } else if (n == -1){
            return nowSeatingAt;
        }

        return null;
    }
}
