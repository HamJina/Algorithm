import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //정답 출력
        Deque<String> stack = new ArrayDeque<>();

        //입력이 온점(.)뿐이면 종료
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            boolean isBalance = true;
            for (int i = 0; i < str.length(); i++) {
                String subStr = str.substring(i, i + 1);
                if(subStr.equals("(") || subStr.equals("[")){
                    stack.push(subStr);
                }
                else if(subStr.equals(")")){
                    //스택이 비워있거나 최상위 요소가 "["인 경우
                    if(stack.isEmpty() || stack.peek().equals("[")) {
                        isBalance = false;
                        break;
                    }
                    else if(stack.peek().equals("(")){
                        stack.pop();
                    }

                }
                else if(subStr.equals("]")){
                    if(stack.isEmpty() || stack.peek().equals("(")) {
                        isBalance = false;
                        break;
                    }
                    else if(stack.peek().equals("[")){
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()) isBalance = false;
            
            if(isBalance) sb.append("yes\n");
            else sb.append("no\n");
            stack.clear();
        }
        System.out.println(sb);

    }
}
