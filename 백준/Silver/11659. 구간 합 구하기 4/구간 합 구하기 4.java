import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //읽어온 String을 공백을 기준으로 분리한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

				//int로의 형변환하기
        int suNo = Integer.parseInt(stringTokenizer.nextToken()); //5
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); //3

        // 구간 합 배열
        long[] S = new long[suNo + 1];

				//5, 4, 3, 2, 1읽기
				//구간 합 배열 S계산하기
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        
        //구하고자 하는 구간 합 계산하기
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}