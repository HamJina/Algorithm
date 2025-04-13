import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        A = new int[n+1][n+1];
        //배열 채우기
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(str.substring(j-1,j));
            }
        }

        //배열 탐색하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(A[i][j] == 1) { //방문 가능한 노드에 대해 DFS 시작하기
                    count = 0;
                    DFS(i, j);
                    result.add(count);
                }
            }
        }


        //정렬한 결과대로 출력하기
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    static void DFS(int i, int j) { //i행 j열에 대해 DFS 실행
        //해당 노드에 방문 표시 하기
        count++;
        A[i][j] = 0;

        //A[i][j]의 인접 노드에 대해 탐색하기
        //인접 노드는 A[i+1][j] A[i-1][j] A[i][j-1] A[i][j+1]
        //인덱스에 대한 조건문 추가하기
        if (i + 1 < A.length && A[i + 1][j] == 1) {
            DFS(i + 1, j);
        }
        if (i - 1 > 0 && A[i - 1][j] == 1) {
            DFS(i - 1, j);
        }
        if (j + 1 < A[i].length && A[i][j + 1] == 1) {
            DFS(i, j + 1);
        }
        if (j - 1 > 0 && A[i][j - 1] == 1) {
            DFS(i, j - 1);
        }
    }
}