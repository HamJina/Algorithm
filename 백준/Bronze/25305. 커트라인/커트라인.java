import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//버블소트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //A 배열의 크기
        int k = Integer.parseInt(st.nextToken()); //상위 k

        st = new StringTokenizer(br.readLine());
        //배열 채우기
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            int max_index = A.indexOf(Collections.max(A.subList(0, n-i))); //0~n-i에서 최댓값 요소 찾기
            if(count == k) {
                System.out.println(A.get(max_index));
                break;
            }
            else {
                int temp = A.get(n-i-1);
                A.set(n-i-1, A.get(max_index));
                A.set(max_index, temp);
            }
        }
    }
}
