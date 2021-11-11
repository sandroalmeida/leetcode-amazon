package info.sandroalmeida;

public class WordSearch {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < cols; y++){
                if(traverse(board, visited, word, 0, x, y))
                    return true;
            }
        }
        return false;
    }

    private static boolean traverse(char[][] board, boolean[][] visited, String word, int position, int x, int y) {
        if(position == word.length()) return true;
        if(word.charAt(position) != board[x][y]) return false;
        if(visited[x][y]) return false;

        visited[x][y] = true;

        int rows = board.length, cols = board[0].length;
        boolean check = false;
        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols)
                if(traverse(board, visited, word, position+1, nx, ny))
                    check = true;
        }
        visited[x][y] = false;

        return check;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','E','E','D'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
