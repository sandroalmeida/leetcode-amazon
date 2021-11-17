package info.sandroalmeida;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> setState = new HashSet<>();
        int days = 0;
        boolean hasCycle = false;

        for(int i = 0; i < n; i++){
            int[] next = nextState(cells);
            String hash = Arrays.toString(next);
            if(!setState.contains(hash)){
                setState.add(hash);
                days++;
            } else{
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if(hasCycle){
            n %= days;
            for(int i = 0; i < n; i++)
                cells = nextState(cells);
        }

        return cells;
    }

    private static int[] nextState(int[] cells) {
        int[] result = new int[cells.length];
        for(int i = 0; i < result.length; i++){
            if(i == 0 || i == result.length - 1)
                result[i] = 0;
            else
                result[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        //Input: cells = [0,1,0,1,1,0,0,1], n = 7
        //Output: [0,0,1,1,0,0,0,0]

        //Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
        //Output: [0,0,1,1,1,1,1,0]

        int[] cells = {1,0,0,1,0,0,1,0};
        int[] result = prisonAfterNDays(cells, 1000000000);
        for(int i: result)
            System.out.print(i + " ");
    }
}
