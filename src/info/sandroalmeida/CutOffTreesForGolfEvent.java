package info.sandroalmeida;

import java.util.*;

public class CutOffTreesForGolfEvent {

    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int cutOffTree(List<List<Integer>> forest) {
        Queue<TreeInfo> treeHeights = getAllTreeHeights(forest);
        int minSteps = 0;
        int x = 0, y = 0;
        while(!treeHeights.isEmpty()){
            TreeInfo currentTree = treeHeights.poll();
            int steps = getMinimumSteps(forest, x, y, currentTree);
            if(steps == -1) return -1;
            minSteps += steps;
            x = currentTree.x;
            y = currentTree.y;
            forest.get(x).set(y, 1);
        }
        return minSteps;
    }

    private static int getMinimumSteps(List<List<Integer>> forest, int x, int y, TreeInfo currentTree) {
        int minSteps = 0;
        int rows = forest.size(), cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i  < size; i++){
                int[] current = queue.poll();
                if(current[0] == currentTree.x && current[1] == currentTree.y)
                    return minSteps;
                for(int[] direction: directions){
                    int nx = current[0] + direction[0];
                    int ny = current[1] + direction[1];
                    if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && forest.get(nx).get(ny) != 0){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private static Queue<TreeInfo> getAllTreeHeights(List<List<Integer>> forest){
        Queue<TreeInfo> treeHeights = new PriorityQueue<>((a,b) -> a.height - b.height);

        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(0).size(); j++){
                int height = forest.get(i).get(j);
                if(height > 1){
                    TreeInfo treeInfo = new TreeInfo(i, j, height);
                    treeHeights.add(treeInfo);
                }
            }
        }
        return treeHeights;
    }

    static class TreeInfo{
        int x;
        int y;
        int height;

        public TreeInfo(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(0,0,4));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(7,6,5));
        forest.add(row1);
        forest.add(row2);
        forest.add(row3);
        System.out.println(cutOffTree(forest));

    }
}
