package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_V2 {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int rows = board.length, cols = board[0].length;
        TrieNode root = buildTrie(words);

        for(int x = 0; x < rows; x++){
            for(int y = 0; y < cols; y++){
                dfs(board, x, y, root, result);
            }
        }
        return result;
    }

    private static void dfs(char[][] board, int x, int y, TrieNode p, List<String> result){
        char current = board[x][y];
        if(current == '#' || p.next[current - 'a'] == null) return;
        p = p.next[current - 'a'];
        if(p.word != null) { // found word
            result.add(p.word);
            p.word = null; // de-duplicate
        }

        board[x][y] = '#';
        int rows = board.length, cols = board[0].length;
        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols){
                dfs(board, nx, ny, p, result);
            }
        }
        board[x][y] = current;
    }

    private static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode p = root;
            for(char c: word.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }


    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));

        char[][] board2 = {{'a'}};
        String[] words2 = {"a"};
        System.out.println(findWords(board2, words2));

        char[][] board3 = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words3 = {"oa","oaa"};
        System.out.println(findWords(board3, words3));
    }

}
