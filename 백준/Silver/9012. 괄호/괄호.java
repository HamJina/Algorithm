import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            boolean isVPS = true;
            String ss = br.readLine();
            char[] charArray = ss.toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                if(c == '(') { //'('이면 push
                    stack.push(c);
                }else if(c == ')'){
                    if(stack.isEmpty()) {
                        isVPS = false; //')'인데 매칭할 '('가 존재하지 않는다면 VPS가 아닌 것
                        break;
                    }
                    else { //stack에 있는'('와 ')'이 매칭 된다.
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty() || !isVPS) System.out.println("NO"); //stack에 매칭 안된 '('이 남아 있거나 isVPS가 false이면 NO출력
            else System.out.println("YES");
            //마지막에서는 stack 비우기
            stack.clear();
        }
    }
}
