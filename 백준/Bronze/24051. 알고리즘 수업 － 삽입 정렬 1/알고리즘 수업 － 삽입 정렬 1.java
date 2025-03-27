import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//버블소트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //A 배열의 크기
        int k = Integer.parseInt(st.nextToken()); //저장횟수

        st = new StringTokenizer(br.readLine());
        //배열 채우기
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            int loc = i - 1; //삽입 대상보다 앞에 있는 요소들
            int newItem = A[i]; //삽입 대상

            while(loc >= 0 && newItem < A[loc]) {
                A[loc + 1] = A[loc];
                count++;
                if(count == k){
                    System.out.println(A[loc]);
                    break;
                };
                loc--;
            }
            if (loc + 1 != i){
                A[loc+1] = newItem;
                count++;
                if(count == k) {
                    System.out.println(newItem);
                    break;
                }
            }
        }

        if(count < k) System.out.println(-1);
    }
}
