import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx=new int[]{-1,0,1,0}; // 상하좌우 이동중 x축 변화량
    static int[] dy=new int[]{0,-1,0,1}; // 상하좌우 이동중 y축 변화량

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start=new StringBuilder(); //입력값을 저장

        // 입력받는 부분
        for(int i=0;i<3;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {

                String temp=st.nextToken();
                if(temp.equals("0")) {
                    start.append("9");
                }
                else
                    start.append(temp);
            }
        }
        // 예시1 입력: start = 193425786

        Queue<String> dq=new LinkedList<>();  // BFS를 사용하기 위함 
        Map<String,Integer> m=new HashMap<>();  // map은 key 중복방지로 노드 방문 여부를 표시하지 않아도됨
        dq.offer(start.toString()); // 큐에 시작 배열 삽입
        m.put(start.toString(),0); // map에는 시작 상태와 이동횟수 0을 넣는다. 

        while(!dq.isEmpty()){
            String present=dq.poll(); 
            int nineLoc=present.indexOf("9"); // 0의 인덱스 
            int x=nineLoc/3; // 이동을 시도하는 x위치
            int y=nineLoc%3; // 이동을 시도하는 y위치

            for(int i=0;i<4;i++){ // 상하좌우 이동을 위해 i를 0~3까지 반복
                int xx=dx[i]+x;
                int yy=dy[i]+y;
                int move=xx*3+yy; // 1차원에서의 이동위치 계산
                if(xx>=0 && xx<3 && yy>=0 && yy<3){
                    StringBuilder next=new StringBuilder(present);
                    char temp=next.charAt(move); // 9와 자리를 바꾸게될 요소값
                    next.setCharAt(nineLoc,temp); // 자리 바꾸기
                    next.setCharAt(move,'9'); // 자리 바꾸기  
                    String nextStr=next.toString(); // StringBuilder -> String
                    if(!m.containsKey(nextStr)){
                        dq.offer(nextStr);
                        m.put(nextStr,m.get(present)+1);
                    }
                }
            }
        }

        if(m.containsKey("123456789")){
            System.out.println(m.get("123456789"));
        }
        else{
            System.out.println(-1);
        }

    }
}