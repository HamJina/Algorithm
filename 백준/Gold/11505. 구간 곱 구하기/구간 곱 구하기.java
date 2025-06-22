import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*      5 2 2 n, m, k
            1 n개의 데이터
            2
            3
            4
            5
            1 3 6
            2 2 5
            1 5 2
            2 3 5*/
    static int treeHeight = 0;
    static long[] tree;
    static int N, M, K;
    static int startIndex, endIndex;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M, K 입력받기
        N = Integer.parseInt(st.nextToken()); // 데이터 개수
        M = Integer.parseInt(st.nextToken()); // 데이터 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간곱 계산 횟수
        // i 구하기 2**i >= N을 만족하는 최솟값 i
        int length = N;
        while(length != 0) {
            length /= 2;
            treeHeight++;
        } // i가 3으로 계산됨
        // 배열 크기 계산하기
        int treeSize = (int) Math.pow(2, treeHeight+1); //2**4=16으로 배열크기 계산됨
        // 트리 배열 초기화하기
        tree = new long[treeSize];

        // start_index와 end_index 계산하기
        startIndex = toSegmentIndex(1);
        endIndex = toSegmentIndex(N);

        // 배열 입력받기
        for (int i = startIndex; i < endIndex + 1; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 배열 초기곱 계산하기
        initTree();

        // 변경 실행하기
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //1이면 데이터 변경, 2이면 구간합 계산
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1)  dataChange(b, c);
            else if(a == 2) {
                System.out.println(segmentMultiply(b, c));
            }
        }

    }

    // 배열 인덱스 -> 세그먼트 트리용 인덱스로 변환하는 함수
    public static int toSegmentIndex(int index) {
        return index + (int) Math.pow(2, treeHeight) - 1;
    }

    // 배열 초기화하기
    public static void initTree() {
        for (int i = startIndex - 1; i > 0 ; i--) {
            tree[i] = (tree[2*i] * tree[2*i+1]) % MOD;
        }
    }

    // 데이터 변경하기 함수
    public static void dataChange(int b, int c) {
        // b번째 데이터값을 c로 변경
        int changeIndex = toSegmentIndex(b);
        tree[changeIndex] = c;
        // 부모 노드 변경해야함
        int parentIndex = changeIndex;
        while(parentIndex > 0) {
            // 부모 노드 인덱스 계산 : tree[2N] * tree[2N+1]
            parentIndex /= 2;
            tree[parentIndex] = (tree[2*parentIndex] * tree[2*parentIndex+1]) % MOD;
        }
    }

    // 구간곱 계산하기 함수
    public static long segmentMultiply(int b, int c) {
        int startIndex = toSegmentIndex(b);
        int endIndex = toSegmentIndex(c);

        long sum = 1;
        while(startIndex <= endIndex) {
            if(startIndex % 2 == 1) {
                sum = (sum * tree[startIndex]) % MOD;
            }
            if(endIndex % 2 == 0) {
                sum = (sum * tree[endIndex]) % MOD;
            }
            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }
        return sum % MOD;
    }
}
