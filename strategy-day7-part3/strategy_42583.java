import java.util.*;
/**
 * strategy_42583
 * [스택/큐] 다리를 지나는 트럭
 */
public class strategy_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Deque<Integer> bridge = new ArrayDeque<>();

        for (int i=0; i<bridge_length; i++){
            bridge.add(0); // 다리길이 만큼 큐가 추가됨
        }

        int time = 0;
        int truchIndex = 0;
        while (truchIndex < truck_weights.length){ // 대기 트럭길이보다 트럭인덱스가 작을 때 반복
            bridgeWeight -= bridge.pollFirst(); // 트럭이 다리에서 내려올 차례이면 트럭 무게는 큐에서 나오고
                                                // 다리에서 내려오지 않는다면 0이 나온다
                                                // 따라서 큐에서 나오는 값을 bridgeWeight 변수에서 빼면 트럭 무게를 알맞게 계산가능

            int truck_weight = truck_weights[truchIndex]; // 대기 트럭에 요소를 하나 가져온다
            if (bridgeWeight + truck_weight <= weight){ // 다리에 올라선 트럭 무게 + 방금 올라온 트럭 무게가 견딜 수 있는지 비교
                bridge.add(truck_weight); // 견딜 수 있을 때, 방금 트럭이 다리에 올라선다
                bridgeWeight += truck_weight; // 다리에 올라선 트럭에 총 무게
                truchIndex++; // 다음 트럭 들어와!!
            } else { // 견딜 수 없을 때,
                bridge.add(0); // 다리에 올라올 수 없다
            }

            time++; // 다리 작업 끝나면 시간 1초 증가
        }
        
        while (bridgeWeight > 0){ // 다리 위에 트럭이 남아있다면, 빌 때까지 진행해야 한다.
            bridgeWeight -= bridge.pollFirst();
            time++;
        }

        return time;
    }
}