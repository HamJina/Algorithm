import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static ArrayList<Integer>[] list;
    public int[] solution(String s) {
        if(s.contains("},")) {
            String[] tuple = s.replace("{", "").split("},");
            tuple[tuple.length - 1] = tuple[tuple.length - 1].replace("}", "");

            list = new ArrayList[tuple.length];
            String[] sorted = Arrays.stream(tuple)
                    .sorted((o1, o2) -> o1.length() - o2.length())
                    .toArray(String[]::new);

            for(int i = 0; i < sorted.length; i++) {
                
                if(i == 0) {
                    list[i] = new ArrayList<>();
                    list[i].add(Integer.parseInt(sorted[i]));
                } else {
                    String[] split = sorted[i].split(",");

                    ArrayList<Integer> ls = Arrays.stream(split)
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(ArrayList::new));
                    list[i] = new ArrayList<>(ls);
                }
            }
            
            int[] result = new int[sorted.length];
            for(int i = list.length - 1; i > 0; i--) {
                list[i].removeAll(list[i - 1]);
                result[i] = list[i].get(0);
            }
            result[0] = list[0].get(0);
            return result;

        } else{
            String raw = s.replace("{", "").replace("}", "");
            return new int[]{Integer.parseInt(raw)};
        }
    }
}