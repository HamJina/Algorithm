import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int[] A = new int[9];
        HashSet<Integer>[] list = new HashSet[9];
        for(int i = 0; i < A.length; i++) {
            if(i == 0) list[i] = new HashSet<>();
            else if(i == 1) {
                A[i] = N;
                list[i] = new HashSet<>(List.of(A[i]));
            }
            else {
                A[i] = A[i-1] + (int) (Math.pow(10, i - 1) * N);
                list[i] = new HashSet<>(List.of(A[i]));
            }
            if(A[i] == number) return i;
        }
        
        for(int n = 1; n < 9; n++) { // n은 N이 나타난 횟수
            for(int i = 1; i <= n; i++) { // i는 n을 두수이 합으로 쪼개기 위함
                int a = i;
                int b = n - i;
                if(a >= b) {
                    for(int k : list[a]) {
                        for(int l : list[b]) {
                            // 사칙연산
                            int g = k >= l ? k : l;
                            int s = k >= l ? l : k;
                            
                            // 덧셈
                            int plus = g + s;
                            if(plus == number) return n;
                            else list[n].add(plus);
                            
                            // 뺄셈
                            int minus = g - s;
                            if(minus == number) return n;
                            else list[n].add(minus);
                            
                            // 나눗셈
                            if(s != 0) {
                                int dive = g / s;
                                if(dive == number) return n;
                                else list[n].add(dive);
                            }
                            
                            // 곱셈
                            int multiply = g * s;
                            if(multiply == number) return n;
                            else list[n].add(multiply);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}