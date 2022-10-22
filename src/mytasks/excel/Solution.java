package mytasks.excel;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i+1]);
        }
        input = scanner.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(input[i+1]);
        }
        input = scanner.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(input[i+1]);
        }
        long time = System.currentTimeMillis();
        int result[] = merge(a,b);
        int result2[] = merge(result, c);

        int result3[] = merge(b,c);
        int result4[] = merge(result3, a);

        int result5[] = merge(a,c);
        int result6[] = merge(result5, b);

        if (result2.length<=result6.length && result2.length<=result4.length) {
            System.out.println(result2.length);
            for (int i = 0; i < result2.length; i++) {
                System.out.print(result2[i]+ " ");
            } }else

        if (result4.length<=result6.length && result4.length<=result2.length) {
            System.out.println(result4.length);
            for (int i = 0; i < result4.length; i++) {
                System.out.print(result4[i]+ " ");
            } }else

        if (result6.length<=result4.length && result6.length<=result2.length) {
            System.out.println(result6.length);
            for (int i = 0; i < result6.length; i++) {
                System.out.print(result6[i]+ " ");
            }
        }
    }
    static int[] merge(int a[], int b[]) {
        int c[] = null;
        int c1[] = null;
        for (int i = 0; i < a.length; i++) {
            int index = i;
            int counter = 0;
            if (a[i] == b[0]) {
                for (int j = 0; j < b.length; j++) {
                    int currentA =a[i];
                    if (index < a.length)
                        currentA =a[index];
                    int currentB = b[j];
                    if(currentA == currentB) {
                        index++;
                        counter++;
                    }else break;
                    if (j==b.length-1) {
                        return a;
                    }
                }
                if(index == a.length) {
                    c = new int[a.length+b.length-counter];
                    for (int k = 0; k < c.length; k++) {
                        if (k < a.length)
                            c[k] = a[k];
                        else
                            c[k] =b[k-(a.length-counter)];
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            int index = i;
            int counter = 0;
            if (b[i] == a[0]) {
                for (int j = 0; j < a.length; j++) {
                    int currentA =b[i];
                    if (index < b.length)
                        currentA =b[index];//
                    int currentB = a[j];//
                    if(currentA == currentB) {
                        index++;
                        counter++;
                    }else break;
                    if (j==b.length-1) {
                        return a;
                    }
                }
                if(index == b.length) {
                    c = new int[a.length+b.length-counter];
                    for (int k = 0; k < c.length; k++) {
                        if (k < b.length)
                            c[k] = b[k];
                        else
                            c[k] =a[k-(b.length-counter)];
                    }
                    break;
                }
            }
        }
        if (c!=null && c1!=null) {
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]);

            }
            System.out.println("     ");
            for (int i = 0; i < c1.length; i++) {
                System.out.print(c1[i]);
            }
            System.out.println(" ");
            if (c.length>c1.length) return c1; else return c;
        } else if(c!=null) return c;
        else if(c1!=null) return c1;

        c = new int[a.length+b.length];
        for (int i = 0; i <c.length; i++) {
            if (i<a.length)
                c[i] = a[i];
            else
                c[i] = b[i-a.length];
        }
        return c;
    }
}