package mytasks.attractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SolutionByNik {

    static Map<Integer, Integer> map1Str;
    static Map<Integer, Integer> map2Str;
    static Map<Integer, Integer> map3Str;

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        map1Str = parse(reader);
        map2Str = parse(reader);
        map3Str = parse(reader);

        reader.close();

        for (int i = 0; i < map1Str.size(); i++) {
            if (map2Str.containsKey(map1Str.get(i))){

            }

        }






    }

    static Map<Integer, Integer> parse(BufferedReader reader) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        String[] input = reader.readLine().split(" ");
        for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
            int key = Integer.parseInt(input[i]);
            int index  = i;
            map.put(key, index);
        }
        return map;
    }

}
