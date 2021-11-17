package info.sandroalmeida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mapLastIndex = new HashMap<>();
        for(int i = 0; i < s.toCharArray().length; i++)
            mapLastIndex.put(s.charAt(i), i);

        List<Integer> result = new ArrayList<>();
        int lastPartition = 0;
        int maxIndex = 0;
        for(int i = 0; i < s.toCharArray().length; i++){
            char c = s.charAt(i);
            int lastIndex = mapLastIndex.get(c);
            maxIndex = Math.max(lastIndex, maxIndex);
            if(maxIndex == i){
                result.add(i - lastPartition + 1);
                lastPartition = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        System.out.println(partitionLabels(s));

        String s2 = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s2));
    }
}
