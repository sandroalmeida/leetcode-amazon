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
        List<String> currentPath = new ArrayList<>();
        currentPath.add(beginWord);

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)){
                    result.add(currentPath);
                    break;
                }
                for(int j = 0; j < currentWord.length(); j++){
                    String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j+1);
                    List<String> neighbors = patternsWords.get(pattern);
                    if(neighbors != null){
                        for(String neighbor: neighbors){
                            if(!visited.contains(neighbor)){
                                currentPath.add(neighbor);
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
