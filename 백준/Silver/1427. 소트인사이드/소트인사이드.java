import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 입력 받은 숫자 (문자열 형태)

        int[] A = new int[str.length()];

        // substring을 사용하여 각 자리 숫자를 배열에 저장
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        // 선택 정렬로 내림차순 정렬
        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        // 결과 출력 (한 줄로 출력)
        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
