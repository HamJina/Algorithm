import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ')') {
                if(deque.isEmpty())
                    count++;
                else {
                    deque.pop();
                }
            } else {
                deque.push('(');
            }
        }
        count += deque.size();
        System.out.println(count);


    }
}