import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int k = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean isPossible = true;
        for (int i = 0; i < n; i++) {

            if(A[i] >= k) {
                while (A[i] >= k) { //k가 A[k]와 값이 같아질떄까지 크기를 키운다.
                    stack.push(k);
                    sb.append("+\n");
                    if (A[i] == k) {
                        sb.append("-\n");
                        stack.pop();
                    }
                    k++;
                }
            }else {
                if(!stack.isEmpty() && A[i] == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                }
                else{
                    isPossible = false;
                }
            }
        }

     if(isPossible) System.out.println(sb.toString());
     else System.out.println("NO");

    }
}
