import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] gate;
    static int[] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        gate = new int[G+1];
        visit = new int[G+1];

        // 게이트 초기화
        for (int i = 1; i <= G; i++) {
            gate[i] = i;
        }

        for (int i = 1; i <= P; i++) {
            int gi = Integer.parseInt(br.readLine());

            if(gate[find(gi)] != 0) {
                visit[find(gi)] = i;
                union(gi);
                count++;
            }
            else break;
        }
        System.out.println(count);
    }

    static void union(int a) {
        gate[find(a)]--;
    }

    static int find(int a) {
        if(gate[a] == a) // a의 대표노드가 자기자신이면 a값 return
            return a;
        else return gate[a] = find(gate[a]);
    }
}