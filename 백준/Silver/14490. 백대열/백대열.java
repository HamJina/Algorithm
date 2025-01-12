import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int divided = 0;
        String[] s = input.split(":");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int min = Integer.min(m, n);

        List<Integer> nums = new ArrayList<>();
        for (int i = min; i > 0 ; i--) {
            if(min % i == 0) nums.add(i);
        }

        for (Integer num : nums) {
            if(m%num == 0 && n%num == 0){
                divided = num;
                break;
            }
        }

        String answer = String.valueOf(m/divided)+":"+String.valueOf(n/divided);
        System.out.println(answer);

    }
}