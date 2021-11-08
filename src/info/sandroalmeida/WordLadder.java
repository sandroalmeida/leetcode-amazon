package info.sandroalmeida;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, List<String>> wordsPattern = new HashMap<>();

        for(String word: wordList){
            for(int i = 0; i < word.length(); i++){
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                List<String> list = wordsPattern.getOrDefault(pattern, new ArrayList<>());
                list.add(word);
                wordsPattern.put(pattern, list);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int result = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                String word = queue.poll();
                if(word.equals(endWord))
                    return result;
                for(int j = 0; j < word.length(); j++){
                    String pattern = word.substring(0,j) + "*" + word.substring(j+1);
                    List<String> neighbors = wordsPattern.get(pattern);
                    if(neighbors != null){
                        for(String neighbor: neighbors){
                            if(!visited.contains(neighbor)){
                                visited.add(neighbor);
                                queue.add(neighbor);
                            }
                        }
                    }
                }
            }
            result += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(begin, end, wordList));
    }
}
