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
        int k = Integer.parseInt(st.nextToken()); //교환 횟수/

        st = new StringTokenizer(br.readLine());
        //배열 채우기
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        int changed = 0;
        for(int i = 0; i < n; i++) {
            int max_index = A.indexOf(Collections.max(A.subList(0, n-i))); //최대값 요소의 인덱스 찾기
            if(max_index != n-1-i) {
                int temp = A.get(n-1-i);
                A.set(n-1-i, A.get(max_index));
                A.set(max_index, temp);
                changed++;
            }
            if(changed == k) break;
        }

        if(changed == k) {
            for (int i = 0; i < n; i++) {
                System.out.print(A.get(i) + " ");
            }
        }
        else if(changed < k) System.out.println(-1);
    }
}
