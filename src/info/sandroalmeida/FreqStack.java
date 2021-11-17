package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if(f > maxfreq)
            maxfreq = f;
        
        group.computeIfAbsent(f, z-> new Stack<>()).push(val);
    }
    
    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) -1);
        if(group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(1);
        freqStack.push(2);
        freqStack.push(3);
        freqStack.push(3);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(4);
        freqStack.push(4);
        freqStack.push(4);
        System.out.println(freqStack.pop());
    }
}