package info.sandroalmeida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AutocompleteSystem {

    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            this.children = new TrieNode[128];
            this.s = null;
            this.times = 0;
            this.hot = new ArrayList<>();
        }

        public int compareTo(TrieNode node){
            if(this.times == node.times)
                return this.s.compareTo(node.s);
            return node.times - this.times;
        }

        public void update(TrieNode node){
            if(!this.hot.contains(node)){
                this.hot.add(node);
            }
            Collections.sort(hot);
            if(hot.size() > 3){
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode current;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        current = root;
        sb = new StringBuilder();

        for(int i = 0; i < sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }

    public void add(String sentence, int t) {
        TrieNode tmp = root;
        List<TrieNode> visited = new ArrayList<>();

        for(char c: sentence.toCharArray()){
            if(tmp.children[c] == null){
                tmp.children[c] = new TrieNode();
            }
            tmp = tmp.children[c];
            visited.add(tmp);
        }

        tmp.s = sentence;
        tmp.times += t;

        for(TrieNode node: visited){
            node.update(tmp);
        }
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c == '#'){
            add(sb.toString(), 1);
            sb = new StringBuilder();
            current = root;
            return result;
        }
        sb.append(c);
        if(current != null){
            current = current.children[c];
        }
        if(current == null)
            return result;
        for(TrieNode node: current.hot){
            result.add(node.s);
        }
        return result;
    }
}