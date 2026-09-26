import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        int pos = n; 
        while(pos != 0) {
            if(pos % 2 == 0) {
                pos /= 2; 
            } else {
                ans++; 
                pos -= 1;
            }
        }

        return ans;
    }
}