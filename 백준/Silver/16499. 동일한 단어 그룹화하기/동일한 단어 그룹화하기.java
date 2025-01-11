import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); //단어 개수

        //n개의 단어 입력받기
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        int groupNum = 0;
        //각각의 String 사전순 나열
        for (int i = 0; i < n; i++) {
            char[] chars = s[i].toCharArray();
            Arrays.sort(chars);

            //새로운 문자열로 반환받아야함!!
            String sorted = new String(chars);
            s[i] = sorted;
        }
        Stream<String> distinct = Arrays.stream(s).distinct();
        System.out.println(distinct.count());
    }
}