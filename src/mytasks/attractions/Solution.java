package mytasks.attractions;

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
    static int[] merge(int[] a, int[] b) {

        int[] с2 = iteratingToMassive(a, b);
        int[] c1 = iteratingToMassive(b, a);

//        проверки создались ли массивы
        if (с2!=null && c1!=null)
            if (с2.length>c1.length) return c1; else return с2;
        else if(с2!=null) return с2;
        else if(c1!=null) return c1;

//        если ничего не выполнилось, то мы сливаем 2 массива
        int[] с = new int[a.length+b.length];
        for (int i = 0; i <с.length; i++) {
            if (i<a.length)
                с[i] = a[i];
            else
                с[i] = b[i-a.length];
        }
        return с;
    }

    static int[] iteratingToMassive(int[] a, int[] b){

//        метод возврашяет массив,
//        если было выполнено одно из условий:
//          1 - массив полностью содержится в другом массиве, тогда мы выводим просто больший массив
//          2 - массив не полностью содержится в другом массиве, только частично, значит мы выводим их слияние
//
//        иначе null

        int[] c;
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
//                    если один массив вошел в другой, то возвращяем больший
                    if (j==b.length-1) {
                        if (a.length>b.length) return a;
                        else return b;
                    }
                }
//                если массив не полностью вошел, а частично, то
//                создается массив "с" , в котором хранится слияние 2-х массивов
                if(index == a.length) {
                    c = new int[a.length+b.length-counter];
                    for (int k = 0; k < c.length; k++) {
                        if (k < a.length)
                            c[k] = a[k];
                        else
                            c[k] =b[k-(a.length-counter)];
                    }
                    return c;
                }
            }
        }
        return null;
    }



}