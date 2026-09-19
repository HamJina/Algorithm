import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,
                Comparator.comparingInt((String o) -> o.charAt(n))
                        .thenComparing(Comparator.naturalOrder()));

        return strings;
    }
}