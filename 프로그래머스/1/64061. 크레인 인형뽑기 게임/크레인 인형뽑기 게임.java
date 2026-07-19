import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>(); // 뽑힌 인형이 들어갈 바구니
        
        // board도 stack 형식으로 변환하기 
        List<Stack<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < board[0].length; i++) {
            list.add(new Stack<>());
        }
        
        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0)list.get(j).push(board[i][j]);
            }
        }
        
        for(int i = 0; i < moves.length; i++) {
            int cur_move = moves[i] - 1; // 현재 뽑힐 위치 (인덱스 위치로 조정)
            int m = 0; // 뽑힌 인형 
            
            if(!list.get(cur_move).isEmpty()) {
                m = list.get(cur_move).pop(); // 인형을 뽑은 다음
                
                // 바구니에 넣기 
                if(!st.isEmpty() && st.peek() == m) { // 새로 뽑힌 인형이 바구니 맨 위에 있는 인형과 같으면 둘이 터져서 없어짐
                    st.pop(); // 터져 없어짐
                    answer += 2;
                } else { // 비어있거나 새로 뽑은 인형과 바구니 상위에 있는 인형이 같지 않으면 인형 넣기 
                    st.push(m);
                }
            } 
            
        }
        return answer;
    }
}