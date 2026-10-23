class Solution {
    private static int[] rx = {0, 0, 1, 2, -1, -2, 0, 0, 1, 1, -1, -1};
    private static int[] ry = {2, 1, 0, 0, 0, 0, -1, -2, 1, -1, 1, -1};
    private static String[][] Places;
    private static boolean isPossible;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Places = places;
        
        for(int k = 0; k < places.length; k++) {
            // k는 대기실 순서 
            isPossible = true;
            String[] p = places[k]; // 현재 대기실의 정보를 담은 배열 
            for(int i = 0; i < p.length; i++) { // 현재 대기실의 요소들을 순회 
                for(int j = 0; j < p[i].length(); j++) {
                    if(Places[k][i].charAt(j) == 'P') { // 현재가 응시자일 경우 
                        // 해당 응시자의 맨해튼 거리 2 이하 이내에 다른 응시자가 있는지 확인 + 거리가 2이내이면 파티션으로 잘 가리고 있는지 확인
                        checkTwoDistance(k, i, j);
                        
                        if(!isPossible) break;
                    }
                }
            }
            answer[k] = isPossible ? 1 : 0;
        }
        
        return answer;
    }
    
    // 맨해튼 거리
        static void checkTwoDistance(int order, int i, int j) {
            // 현재 응시자 위치 i, j를 기준으로 맨해튼 거리 2 이하 이내에 응시자 확인
            for(int n = 0; n < rx.length; n++) {
                int nx = i + rx[n];
                int ny = j + ry[n];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue; // 범위를 벗어나는 경우는 보지 않는다.
                }
                
                if(Places[order][nx].charAt(ny) == 'P') {
                    // 현재 맨해튼 거리 2 이하 이내에 다른 응시자가 있는 상태 
                    // 응시자들 사이에 파티션이 잘 있는지 확인하기 
                    if(!isPartition(order, i, j, nx, ny)) { // 현재 i, j와 nx, ny 사이에 파티션이 있는지 확인
                        // 파이션이 잘 있지 않는 경우 
                        isPossible = false;
                        break;
                    }
                }
            }
        }
        
        static boolean isPartition(int order, int x1, int y1, int x2, int y2) {
            // 행 또는 열이 같은 경우
            if(x1 == x2) {
                if(Places[order][x1].charAt((y1 + y2) / 2) != 'X') {
                    return false;
                }
            } else if(y1 == y2) {
                if(Places[order][(x1 + x2) / 2].charAt(y1) != 'X') {
                    return false;
                }
            } else {
                if(Places[order][x1].charAt(y2) != 'X' || Places[order][x2].charAt(y1) != 'X') {
                    return false;
                }
            }
            return true;
        }
}