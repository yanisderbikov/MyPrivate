package mytasks.evennumbers;

import java.util.Scanner;

public class Sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]), k = Integer.parseInt(strs[1]);
        strs = scanner.nextLine().split(" ");
        boolean firstsEnded = true;
        int maxLenght = 0;

        int skipsFirsts = 0;
        for (int i = 0; i < n; i++) {
            int currentInt = Integer.parseInt(strs[i]) % 2;
//            if (i )
            if (currentInt == 0){
                maxLenght++;
            } else if (currentInt != 0 ){

            }


        }


    }
}
