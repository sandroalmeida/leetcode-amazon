package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    static boolean[][] visited;

    public static int numIslands(char[][] grid) {

        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    traverse(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void traverse(int x,int y,char[][] grid){
        visited[x][y] = true;
        List<Integer[]> neighbors = getNeighbors(x,y,grid);
        for(Integer[] neighbor: neighbors){
            traverse(neighbor[0],neighbor[1],grid);
        }
    }

    private static List<Integer[]> getNeighbors(int x,int y,char[][] grid){
        List<Integer[]> neighbors = new ArrayList<>();
        // Left
        if(y > 0 && grid[x][y-1] == '1' && !visited[x][y - 1])
            neighbors.add(new Integer[]{x,y-1});
        // Right
        if(y < grid[0].length - 1 && grid[x][y+1] == '1' && !visited[x][y + 1])
            neighbors.add(new Integer[]{x,y+1});
        // Top
        if(x > 0 && grid[x-1][y] == '1' && !visited[x - 1][y])
            neighbors.add(new Integer[]{x-1,y});
        // Bottom
        if(x < grid.length - 1 && grid[x+1][y] == '1' && !visited[x + 1][y])
            neighbors.add(new Integer[]{x+1,y});
        return neighbors;
    }

    public static void main(String[] args) {
        //Input: grid = [
        //  ['1','1','1','1','0'],
        //  ['1','1','0','1','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','0','0','0']
        //]
        //Output: 1
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid1));
        
        //Input: grid = [
        //  ['1','1','0','0','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','1','0','0'],
        //  ['0','0','0','1','1']
        //]
        //Output: 3
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid2));
    }
}
