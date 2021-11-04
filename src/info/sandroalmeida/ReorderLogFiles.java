package info.sandroalmeida;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> logComparator = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if(!isDigit1 && !isDigit2){
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0)
                        return cmp;
                    return split1[0].compareTo(split2[0]);
                }

                if(!isDigit1 && isDigit2){
                    return -1;
                } else if(isDigit1 && !isDigit2){
                    return 1;
                } else{
                    return 0;
                }
            }
        };

        Arrays.sort(logs, logComparator);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = reorderLogFiles(logs);
        for(String log: output)
            System.out.print(log + " - ");

        System.out.println("");

        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] output2 = {"g1 act car","a8 act zoo","ab1 off key dog","zo4 4 7","a1 9 2 3 1"};
        for(String log: output2)
            System.out.print(log + " - ");
    }
}
