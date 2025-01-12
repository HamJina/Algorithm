import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int divided = 0;
        String[] s = input.split(":");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int min = Integer.min(m,n);
        int max = Integer.max(m,n);
        int gcd = gcd(min, max);

        System.out.println(m/gcd+":"+n/gcd);

    }

    static int gcd(int a, int b) {
        if(b%a == 0) return a;
        else return gcd(b%a, a);
    }
}