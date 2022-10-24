package mytasks.attractions;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] a = parse(reader);
        int[] b = parse(reader);
        int[] c = parse(reader);

        reader.close();

//        если будет неверное решение, то добавить еще вариации
        int[] var1 = theSmallest(merge(a, b, c), merge(a, c, b));
        int[] var2 = theSmallest(merge(a, b, c), merge(a, c, b));
        int[] var3 = theSmallest(merge(c, a, b), merge(c, b, a));

//        print(var1);
//        print(theSmallest(var1, var2));
//        print(theSmallest(theSmallest(var1, var2), var3));

        printSout(var1);
        printSout(theSmallest(var1, var2));
        printSout(theSmallest(theSmallest(var1, var2), var3));

    }

    static int[] parse(BufferedReader reader) throws IOException {


        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i+1]);
        }

        return a;
    }

    static int[] merge(int[] a, int[] b, int[] c) {
// TODO: 23.10.2022 подумать когда их просто склеивать после ифов или до
        int[] ab1 = iteratingToMassive(a, b);
        int[] ab2 = iteratingToMassive(b, a);

//        в этих ифах нужно сделать аб и с и с аб, и выкинуть наименьший из них
        int[] result1 = theSmallest(iteratingToMassive(ab1, c), iteratingToMassive(c, ab1));
        int[] result2 = theSmallest(iteratingToMassive(ab2, c), iteratingToMassive(c, ab2));

        return theSmallest(result1, result2);

    }

    static int[] iteratingToMassive(int[] a, int[] b){

//        метод возврашяет массив,
//        если было выполнено одно из условий:
//          1 - массив полностью содержится в другом массиве, тогда мы выводим просто больший массив
//          2 - массив не полностью содержится в другом массиве, только частично, значит мы выводим их слияние
//          3 - массивы не выолненли эти условия, то они просто скреливаются
//
//        иначе


        if (a == null && b == null) return null;
        else if (a == null && b != null) return b;
        else if (a != null && b == null) return a;
        else {
            {
                for (int i = 0; i < a.length; i++) {
                    int index = i;
                    int counter = 0;
                    if (a[i] == b[0]) {
                        for (int j = 0; j < b.length; j++) {
                            int currentA = a[i];
                            if (index < a.length)
                                currentA = a[index];
                            int currentB = b[j];
                            if (currentA == currentB) {
                                index++;
                                counter++;
                            } else break;
//                    если один массив вошел в другой, то возвращяем больший
                            if (j == b.length - 1) {
                                if (a.length > b.length) return a;
                                else return b;
                            }
                        }
//                если массив не полностью вошел, а частично, то
//                создается массив "с" , в котором хранится слияние 2-х массивов
                        if (index == a.length) {
                            int[] c = new int[a.length + b.length - counter];
                            for (int k = 0; k < c.length; k++) {
                                if (k < a.length)
                                    c[k] = a[k];
                                else
                                    c[k] = b[k - (a.length - counter)];
                            }
                            return c;
                        }
                    }
                }
            }
        }
//        если ничего не создалось, то нужно выполнить слияние
        int[] together = new int[a.length+ b.length];
        for (int i = 0; i < together.length; i++) {
            if (i < a.length)
                together[i] = a[i];
            else
                together[i] = b[i - a.length];
        }
        return together;
    }

    static int[] theSmallest(int[] a, int[] b){
        if (a != null && b != null) {
            if (a.length < b.length)
                return a;
            else
                return b;
        }else if (a != null) return a;
        else return b;

    }

    static void print(int[] a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(a.length));
        writer.write("\n");
        for (int i = 0; i < a.length ; i++) {
            writer.write(a[i] + " ");
        }
        writer.flush();
        writer.close();
    }

    static void printSout(int[] a){
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}