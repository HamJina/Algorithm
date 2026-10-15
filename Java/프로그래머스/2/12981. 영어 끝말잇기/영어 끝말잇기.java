import java.util.*;

class Solution {
    private static String prev_word;
    private static HashSet<String> set = new HashSet<>();
    public int[] solution(int n, String[] words) {
        // set: tank
        prev_word = words[0]; // tank
        set.add(prev_word);
        for(int i = 1; i < words.length; i++) {
            String cur_word = words[i]; // kick
            
            if(duplicateWord(cur_word) || oneWord(cur_word) || !prevStart(cur_word)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            set.add(cur_word);
            prev_word = cur_word;
        }
        return new int[]{0, 0};
    }
    
    static boolean duplicateWord(String cur_word) {
        return set.contains(cur_word); // true이면 탈락
    }
    
    static boolean oneWord(String cur_word) {
        return cur_word.length() == 1; // 길이가 1이면 탈락
    }
    
    static boolean prevStart(String cur_word) {
        char c = prev_word.charAt(prev_word.length() - 1);
        return cur_word.charAt(0) == c;
    }
}