package info.sandroalmeida;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(String word: words){
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < cols; y++){
                    if(bfs(board, visited, x, y, 0, word))
                        result.add(word);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static boolean bfs(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
        if(board[x][y] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;

        visited[x][y] = true;
        boolean response = false;
        int rows = board.length, cols = board[0].length;
        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0  && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]){
                if(bfs(board, visited, nx, ny, index+1, word))
                    response = true;
            }
        }
        visited[x][y] = false;

        return response;
    }

    public static void main(String[] args) {
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
//        System.out.println(findWords(board, words));
//
//        char[][] board2 = {{'a'}};
//        String[] words2 = {"a"};
//        System.out.println(findWords(board2, words2));

        char[][] board3 = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words3 = {"oa","oaa"};
        System.out.println(findWords(board3, words3));
    }

}
