import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0; // 경과 시간
        ArrayDeque<Integer> truck = new ArrayDeque<>();

        for(Integer w : truck_weights) {
            truck.addLast(w);
        }

        ArrayDeque<Truck> bridge = new ArrayDeque<>();

        int cur_truck;
        Truck poll_truck;
        int cur_weight = 0;

        while(!truck.isEmpty()) {
            t++;

            // 다리를 다 건넌 트럭이 있는지 확인
            if(!bridge.isEmpty()) {
                poll_truck = bridge.peekFirst(); // 나오려는 트럭
                if(t - poll_truck.time >= bridge_length) {
                    // 나올 수 있음
                    cur_weight -= poll_truck.weight;
                    bridge.pollFirst();
                }
            }
            
            cur_truck = truck.peekFirst(); // 새로 다리를 건너려는 트럭

            if(weight >= cur_weight + cur_truck) { // 새로운 트럭이 다리를 건너도 됨
                cur_weight += cur_truck;
                bridge.addLast(new Truck(cur_truck, t));
                truck.pollFirst();
            }
        }

        return t += bridge_length;
    }

    static class Truck {
        int weight;
        int time;

        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}