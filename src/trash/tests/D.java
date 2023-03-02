package trash.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] input1 = reader.readLine().split(" ");
        String[] input2 = reader.readLine().split(" ");
        String[] input3 = reader.readLine().split(" ");

        SortedMap<Integer, List<Integer>> allMapIncome = new TreeMap<>();
        SortedMap<Integer, List<Integer>> mapNeedStudy = new TreeMap<>();

        parseFor1(mapNeedStudy, allMapIncome, input1, input2); // array is already sorted
        int[] stud = new int[mapNeedStudy.size()];
        int[] all  = new int[allMapIncome.size()];

        int j = 0;
        for (int val : mapNeedStudy.keySet()){
            stud[j++] = val;
        }
        j = 0;
        for (int val : allMapIncome.keySet()){
            all[j++] = val;
        }

        /// TODO: 14.02.2023 realise input3
        int[] countriesParents = new int[input3.length];
        for (int i = 0; i < input3.length; i++) {
            countriesParents[i] = Integer.parseInt(input3[i]);
        }

        // main exe
        N = Integer.parseInt(reader.readLine());
        input1 = reader.readLine().split(" ");
        input2 = reader.readLine().split(" ");
        input3 = reader.readLine().split(" ");


        for (int i = 0; i < N; i++) {
            int par1 = Integer.parseInt(input1[i]);
            int par2 = Integer.parseInt(input2[i]);
            int par3 = Integer.parseInt(input3[i]);

            int result = filter(i, par1,  par2,  par3,
                    stud, all, mapNeedStudy, allMapIncome, countriesParents);

            System.out.print(result + " ");
        }
    }

    static int filter(int person, int par1, int par2, int par3,
                      int[] needStudy, int[] allCountries,
                      Map<Integer, List<Integer>> mapNeedStudy, Map<Integer, List<Integer>> allMapIncome,
                      int[] countriesParents){


        // 1 фильтр. Если образование есть, то используются все страны.
        // Иначе, берем только те страны, в которые можно без образования
        int result;
        if (par2 == 1){
            result = filter3(par1, allCountries, allMapIncome);
        }else {
            result = filter3(par1, needStudy, mapNeedStudy);
        }

        // самое последние добавление (если есть гражданство)
        // просто использовать инт, страны и сравнить его в конце
        if (par3!= 0 && countriesParents[par3 - 1] == 1){
            return result == 0 ? par3 : Math.min(par3, result);
        }else {
            return result;
        }
    }
    static int filter3(int target, int[] nums, Map<Integer, List<Integer>> map){

        int index = search(nums, target);

        if (index == -1) return 0;

// TODO: 16.02.2023 как ускорить эту тему?
//  / может быть нужно уже чтоб сразу по странам было
        int min = Integer.MAX_VALUE;
        min = getMin(nums, map, index, min);
        // врнуть наименьший
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }

    private static int getMin(int[] nums, Map<Integer, List<Integer>> map, int index, int min) {
        for (int i = index; i >= 0 ; i++) {
            for (int val : map.get(nums[i])){
                min = Math.min(min, val);
            }
        }
        return min;
    }

    static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if (nums[nums.length - 1] <= target) return nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) {
                right = mid; // right could be the result
            } else {
                left = mid + 1; // mid + 1 could be the result
            }
        }

        // 1 element left at the end
        // post-processing
        return left - 1;
    }

    static void parseFor1(SortedMap<Integer, List<Integer>> mapStud, SortedMap<Integer, List<Integer>> mapAll,
                             String[] input1, String[] input2){
        // нужно вернуть массив, где нужно образование и где нет с соответсвующими к ним мапами


        for (int i = 0; i < input1.length; i++) {
            int minIncome = Integer.parseInt(input1[i]);
            int study = Integer.parseInt(input2[i]);
            // должен быть массив все, где есть 0 и полностью весь массив без разницы есть или нет
            if (study == 0){
                if (mapStud.containsKey(minIncome)){
                    mapStud.get(minIncome).add(i);
                }else {
                    int finalI = i;
                    mapStud.put(minIncome, new ArrayList<>(){{add(finalI);}});
                }
            }
            if (mapAll.containsKey(minIncome)){
                mapAll.get(minIncome).add(i);
            }else {
                int finalI = i;
                mapAll.put(minIncome, new ArrayList<>(){{add(finalI);}});
            }
        }

    }
}
