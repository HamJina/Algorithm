import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //주어질 문자 갯수
        int m = Integer.parseInt(st.nextToken()); //부분 문자열 길이, 길이가 m인 슬라이딩 윈도우 적용

        st = new StringTokenizer(br.readLine());
        String ss = st.nextToken();
        char[] charArray = ss.toCharArray();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());


        int count = 0;
        //초기 슬라이딩 윈도우
        int a1 = 0, c1 = 0, g1 = 0, t1 = 0;
        for (int i = 0; i < m; i++) {
            switch (charArray[i]){
                case 'A': a1++; break;
                case 'C': c1++; break;
                case 'G': g1++; break;
                case 'T': t1++; break;
                default: break;
            }
            
        }
        if(a1 >= a && c1 >= c && g1 >= g && t1 >= t) count++;

        for (int i = m; i < n; i++) {
            switch (charArray[i]){
                case 'A': a1++; break;
                case 'C': c1++; break;
                case 'G': g1++; break;
                case 'T': t1++; break;
                default: break;
            }
            switch (charArray[i-m]){
                case 'A': a1--; break;
                case 'C': c1--; break;
                case 'G': g1--; break;
                case 'T': t1--; break;
                default: break;
            }
            if(a1 >= a && c1 >= c && g1 >= g && t1 >= t) count++;


        }

        System.out.println(count);
    }


}
