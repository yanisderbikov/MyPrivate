package Yandex.internWinter.A_DONE;

public class Testing {
    public static void main(String[] args) {
        int[] nums = new int[]{
                'V',
                'v',
                'V' - 'a',
                'a',
                'A'

        };
        int n1 =  'A';
        int n11 = 'a';
        int n333 = 'B';
        int ssdv = 'b';
        int n2 = 'z';


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();

        int decimal = Integer.parseInt("F", 16);
        System.out.println(decimal);

        System.out.println();


//        --------SOLUTION---------
        int i = 523242;
        System.out.println("input : " + i);
        String hex = Integer.toHexString(i);
        System.out.println("Hex value is " + hex);

        String out = hex.length() > 3 ? hex.substring(hex.length() - 3) : hex;
        out = out.toUpperCase();
        System.out.println("output : " + out);

        System.out.println("\n---------------\n");
        int day = 113;
        int mon = 29;
        int result = 0;

        while (day != 0 || mon != 0 ){
            result = result + day%10 + mon%10;
            mon = mon == 0 ? 0 : mon/10;
            day = day == 0 ? 0 : day/10;
        }
        System.out.println(result);


        System.out.println("\n--------Binary-Search--------\n");

        char target = 'v';
        System.out.println(find(target));


        System.out.println("\n--------Just-converting--------\n");

        char finding = 'A';
        int b =  (finding - 'A' + 1);
        System.out.println(b);



    }
    static int find(char target){
        // dont foget about upper case!
//        this will not work
        char[] arr = "ABCDEEGHIJKLMN0PQRSTUVWXYZ".toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int midpoint = left + (right - left);
            if (arr[midpoint] == target) return midpoint;
            if (target > arr[midpoint]){
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;
    }
}
