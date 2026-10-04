import java.util.*;

class Solution {
    private static HashSet<Character> set = 
        new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    private static ArrayList<FileName> list = new ArrayList<>();
    public String[] solution(String[] files) {
        for(int k = 0; k < files.length; k++) {
            String file = files[k];
            int startIndex = -1;
int endIndex = -1;
for (int i = 0; i < file.length(); i++) {
    if (set.contains(file.charAt(i))) {
        if (startIndex == -1) startIndex = i;
        endIndex = i;
        if (endIndex - startIndex + 1 == 5) break; // NUMBER 최대 5자리
    } else if (startIndex != -1) {
        break; // 숫자 구간이 끝나면 중단
    }
}
            list.add(new FileName(file.substring(0, startIndex), 
                                  Integer.valueOf(file.substring(startIndex, endIndex + 1)),  k, file));
            
        }
        
        return list.stream()
        .sorted((o1, o2) -> {
            int headCompare = o1.head.compareToIgnoreCase(o2.head);
            if (headCompare != 0) {
                return headCompare;
            }
            if (o1.number != o2.number) {
                return Integer.compare(o1.number, o2.number);
            }
            return Integer.compare(o1.order, o2.order);
        })
        .map(o -> o.fileName)
        .toArray(String[]::new);
        
    }
    
    class FileName {
        String head;
        int number;
        int order; // 파일명의 원래 순서
        String fileName;
        
        FileName(String head, int number, int order, String fileName) {
            this.head = head;
            this.number = number;
            this.order = order;
            this.fileName = fileName;
        }
    }
}