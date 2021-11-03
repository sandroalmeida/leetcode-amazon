package info.sandroalmeida;

import java.util.*;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");

        Set<String> setBanned = new HashSet<>();
        Collections.addAll(setBanned, banned);

        Map<String, Integer> mapWords = new HashMap<>();
        for(String word: words){
            if(!setBanned.contains(word)){
                mapWords.put(word, mapWords.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(mapWords.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
