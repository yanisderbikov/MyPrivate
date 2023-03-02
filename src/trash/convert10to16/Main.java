package trash.convert10to16;

public class Main {
    public static void main(String[] args) {
        long binary = 11_0101_0101;
        System.out.println(convert((int) binary));
    }
    static long convert(int binary){
//    covert to ten
        int j = 0;
        long sumTen = 0;
        int remains = 0;
        while (binary != 0){
            remains = binary % 10;
            sumTen = sumTen + remains * pow2(j);
            binary = binary / 10;
            j++;
        }
        if (remains == 1){
            sumTen = sumTen + 1;
        }
//    convert to 16

        return sumTen;
    }

    static long pow2(int to){
        if (to == 0){
            return 0;
        }
        int result = 2;
        for (int i = 1; i < to; i++) {
            result = result * 2;
        }
        return result;
    }

}
