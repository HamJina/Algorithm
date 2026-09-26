import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 총 카펫 수
        
        int width = 0; // 가로
        int height = 0; // 세로 
        for(int i = 3; i <= Math.sqrt(total); i++) {
            if(total % i == 0) {
                int remaining_brown = brown;
                int remaining_yellow = yellow;
                width = i >= total / i ? i : total / i; // 가로
                height = i < total / i ? i : total / i; // 세로
                System.out.println("width: " + width + ", height: " + height);
                
                while(remaining_brown > 0) {
                    int cur_width = width;
                    int cur_height = height;
                 
                    remaining_brown -= (width * height - (width - 2) * (height - 2));
                    cur_width -= 2;
                    cur_height -= 2;
                }
                if(remaining_brown == 0) {
                    return new int[]{width, height};
                }
                remaining_yellow -= width * height;
            }
        }
        return new int[]{width, height};
    }
}