package info.sandroalmeida;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsOrigin {

    static class Point{
        double height;
        int[] point;

        public Point(double height, int[] point) {
            this.height = height;
            this.point = point;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {

        Queue<Point> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> a.height));
        for(int[] point: points)
            minHeap.add(new Point(calcHeight(point), point));

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll().point;
        }
        return result;
    }

    private static double calcHeight(int[] point){
        return Math.pow(Math.abs(point[0]),2) + Math.pow(Math.abs(point[1]),2);
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] result = kClosest(points,2);
        for(int[] point: result)
            System.out.println(point[0] + ", " + point[1]);
    }
}
