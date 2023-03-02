package trash.tests;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class C {
    public void maxProfit(int[] nums) {

        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        
    }
}