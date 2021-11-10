package info.sandroalmeida;

public class FloodFill {

    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length, cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        traverse(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    private static void traverse(int[][] image, int x, int y, int newColor, int oldColor, boolean[][] visited) {
        int currentColor = image[x][y];
        int rows = image.length, cols = image[0].length;
        visited[x][y] = true;

        if(currentColor == oldColor)
            image[x][y] = newColor;
        else
            return;

        for(int[] direction: directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0 && nx < rows && ny >=0 && ny < cols && !visited[nx][ny]){
                traverse(image, nx, ny, newColor, oldColor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int x = 1, y = 1;
        floodFill(image, x, y, 2);
    }
}
