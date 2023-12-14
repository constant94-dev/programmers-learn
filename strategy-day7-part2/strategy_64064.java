import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * strategy_64064
 * [2019 카카오 개발자 겨울 인턴십] 불량 사용자
 * 
 * 1차 아이디어
 * 1. 제재 아이디가 포함된 유저 아이디를 찾는다.
 * 2. 제재 아이디 후보군을 사용해 경우의 수를 만든다.
 * 3. 경우의 수가 만들어질 때마다 카운팅한다.
 * 4. 카운팅 값을 리턴한다.
 */
public class strategy_64064 {
    private void count(int index, Set<String> banned,
                      String[][] bans, Set<Set<String>> banSet){ // 싱테 깂: (index,banned)
        if (index == bans.length){ // 종료조건
            banSet.add(new HashSet<>(banned));
            return;
        }
        
        for (String id : bans[index]){ // 점화식
            if (banned.contains(id)) continue; // 누적된 제재 아이디 리스트에서 특정 제재 아이디가 포함
            // 포함되지 않을 때, 제재 아이디를 리스트에 추가
            banned.add(id);
            count(index+1,banned,bans,banSet);
            banned.remove(id); // 제재 아이디를 하나씩 제거하며 조합을 만든다
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        // * -> . 으로 변경 후 user_id에서 정규표현식을 사용해 banned에 값과 일치하는 것만 1차원 배열로 만든다
        // 최종적으로 2차원 배열을 만들어 전체 제재 아이디 후보군을 만든다.
        String[][] bans = Arrays.stream(banned_id)
            .map(banned->banned.replace('*','.'))
            .map(banned->Arrays.stream(user_id)
                .filter(id->id.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);
        
        Set<Set<String>> banSet = new HashSet<>();
        count(0,new HashSet<>(),bans,banSet);
        int answer = banSet.size();
        
        return answer;
    }
    public static void main(String[] args) {
        String[] user_id = {"frodo","fradi","crodo","abc123","frodoc"};
        String[] banned_id = {"fr*d*","abc1**"};
        new strategy_64064().solution(user_id, banned_id);
    }
}