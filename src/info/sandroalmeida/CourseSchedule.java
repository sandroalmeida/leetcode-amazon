package info.sandroalmeida;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

//Input: numCourses = 2, prerequisites = [[1,0},{0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graphCourses = new HashMap<>();

        for(int[] prereq: prerequisites){
            if(graphCourses.containsKey(prereq[1])){
                graphCourses.get(prereq[1]).add(prereq[0]);
            } else{
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(prereq[0]);
                graphCourses.put(prereq[1], nextCourses);
            }
        }

        boolean[] path = new boolean[numCourses];

        for(int current = 0; current < numCourses; current++){
            if(isCyclic(current, graphCourses, path))
                return false;
        }
        return true;
    }

    private static boolean isCyclic(int current, Map<Integer, List<Integer>> graphCourses, boolean[] path){

        //if this node is already visited there's a cycle
        if(path[current]) return true;

        // if there's no more courses there's no cycle
        if(!graphCourses.containsKey(current)) return false;

        // path for backtracking
        path[current] = true;

        // backtracking
        boolean response = false;
        for(int nextCourse: graphCourses.get(current)){
            response = isCyclic(nextCourse, graphCourses, path);
            if(response) break;
        }

        // after backtracking remove node from path
        path[current] = false;

        return response;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,2},{2,1},{1,0},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(canFinish(20, prerequisites));
    }
}
