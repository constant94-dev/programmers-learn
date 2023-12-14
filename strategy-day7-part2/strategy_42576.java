import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * strategy_42576
 * [해시] 완주하지 못한 선수
 */
public class strategy_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. 참여한 선수 명단 해시를 생성
        Map<String,Integer> participantMap = new HashMap<>();
        for (String part : participant){
            participantMap.put(
                part,
                participantMap.getOrDefault(part, 0)+1); // 등장한 횟수 value
        }

        // 2. 완주한 선수 명단을 순회
        for (String comp : completion){
            // 3. 완주한 선수 명단이 참여한 선수 명단 해시에 있으면 value -1 (등장횟수 차감)
            participantMap.put(comp, participantMap.get(comp)-1);
        }

        // 4. 참여한 선수 명단 해시를 순회 value 0이 아닌 마지막 주자 찾기
        for (Map.Entry<String,Integer> map : participantMap.entrySet()){
            System.out.println("결과 순회: "+map.getKey()+"\t"+map.getValue());
            if (map.getValue() != 0){
                answer = map.getKey();
                break;
            }
        }
        
        return answer;
    }
}