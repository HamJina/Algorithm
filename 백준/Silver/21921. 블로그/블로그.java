import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        //슬라이딩 윈도우 초기화하기
        for (int i = 0; i < x; i++) {
            sum += array[i];
        }

        int max = sum;
        int count = 1; //최대 방문자수 일수
        //슬라이딩 윈도우 적용하여 최대 방문자수 찾기
        for (int i = x; i < array.length; i++) {
            sum += array[i] - array[i-x];

            if(sum == max) {
                count++;
            } else if(sum > max){
                max = sum;
                count = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
