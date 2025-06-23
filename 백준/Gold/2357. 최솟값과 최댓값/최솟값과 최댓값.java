import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*      10 4
            75
            30
            100
            38
            50
            51
            52
            20
            81
            5 // 10개의 데이터 개수
            1 10
            3 5
            6 9
            8 10 // 4개의 질의 */
    static int treeHeight = 0;
    static long[] minTree, maxTree;
    static int N, M, K;
    static int startIndex, endIndex;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M, K 입력받기
        N = Integer.parseInt(st.nextToken()); // 데이터 개수
        M = Integer.parseInt(st.nextToken()); // 질의 개수

        // i 구하기 2**i >= N을 만족하는 최솟값 i
        int length = N;
        while(length != 0) {
            length /= 2;
            treeHeight++;
        }

        // 배열 크기 계산하기
        int treeSize = (int) Math.pow(2, treeHeight+1);
        // 트리 배열 초기화하기
        minTree = new long[treeSize];
        maxTree = new long[treeSize];

        // start_index와 end_index 계산하기
        startIndex = toSegmentIndex(1); // 8
        endIndex = toSegmentIndex(N); // 17

        // 배열 입력받기
        for (int i = startIndex; i < endIndex + 1; i++) {
            long l = Long.parseLong(br.readLine());
            minTree[i] = l;
            maxTree[i] = l;
        }

        // 배열 초기 최솟값, 최댓값 계산하기
        initTree();

        // 질의 입력받기
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //1이면 데이터 변경, 2이면 구간합 계산
            int b = Integer.parseInt(st.nextToken());

            System.out.println(findMin(a, b) + " " + findMax(a, b));
        }

    }

    // 배열 인덱스 -> 세그먼트 트리용 인덱스로 변환하는 함수
    public static int toSegmentIndex(int index) {
        return index + (int) Math.pow(2, treeHeight) - 1;
    }

    // 배열 초기화하기
    public static void initTree() {
        for (int i = startIndex - 1; i > 0 ; i--) {
            minTree[i] = Math.min(minTree[2*i], minTree[2*i+1]);
            maxTree[i] = Math.max(maxTree[2*i], maxTree[2*i+1]);
        }
    }

    public static long findMin(int startIndex, int endIndex) {
        int start = toSegmentIndex(startIndex);
        int end = toSegmentIndex(endIndex);

        int min = Integer.MAX_VALUE;
        while(start <= end) {
            if(start % 2 == 1) {
                min = Math.min(min, (int) minTree[start]);
            }
            if(end % 2 == 0) {
                min = Math.min(min, (int) minTree[end]);
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return min;
    }

    public static long findMax(int startIndex, int endIndex) {
        int start = toSegmentIndex(startIndex);
        int end = toSegmentIndex(endIndex);

        int max = Integer.MIN_VALUE;
        while(start <= end) {
            if(start % 2 == 1) {
                max = Math.max(max, (int) maxTree[start]);
            }
            if(end % 2 == 0) {
                max = Math.max(max, (int) maxTree[end]);
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return max;
    }
}
