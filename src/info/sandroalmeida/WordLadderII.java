package info.sandroalmeida;

import java.util.*;

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)) return result;

        Map<String, List<String>> patternsWords = new HashMap<>();
        for(String word: wordList){
            for(int i = 0; i < word.length(); i++){
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                List<String> list = patternsWords.getOrDefault(pattern, new ArrayList<>());
                list.add(word);
                patternsWords.put(pattern, list);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        List<Map.Entry<String, Integer>> completedPath = new ArrayList<>();
        int level = 0;
        completedPath.add(new AbstractMap.SimpleEntry<>(beginWord, level));

        while(!queue.isEmpty()){
            level++;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)){
                    break;
                }
                for(int j = 0; j < currentWord.length(); j++){
                    String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j+1);
                    List<String> neighbors = patternsWords.get(pattern);
                    if(neighbors != null){
                        for(String neighbor: neighbors){
                            if(!visited.contains(neighbor)){
                                completedPath.add(new AbstractMap.SimpleEntry<>(neighbor, level));
                                queue.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(findLadders(begin, end, wordList));
    }
}
