package info.sandroalmeida;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int maxRooms = 0;

        for(int i = 0; i < intervals.length; i++){
            int[] curMeeting = intervals[i];
            while(maxHeap.size() > 0 && curMeeting[0] >= maxHeap.peek()[1]){
                maxHeap.poll();
            }
            maxHeap.add(curMeeting);
            maxRooms = Math.max(maxRooms, maxHeap.size());
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }

}
