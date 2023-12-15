import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * strategy_42586
 * [스택/큐] 기능개발
 */
public class strategy_42586 {    
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 결과리스트와 완료일자 큐 생성
        List<Integer> answers = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        // 2. 작업 완료일자를 구한다
        int length = progresses.length;
        for (int i=0; i<length; i++){
            deque.add(i);
        }
        
        // 3. 완료일자를 순서대로 빼낸다
        int days = 0; // 현재완료일자
        int count = 0; // 배포 수
        while (!deque.isEmpty()){
            int index = deque.pollFirst();
            int expire = (int) Math.ceil(
                (double) (100-progresses[index]) / speeds[index]); // 소수점 자리를 올림
            
            if (expire > days){ // 다음 완료일자와 현재완료일자 비교
                if (days != 0){
                    answers.add(count);
                    count = 0;
                }
                days = expire; // 다음 완료일자가 다음 배포일수 기준이 됨
            }
            
            count++;
        }
        answers.add(count); // 큐에서 빠져나오면 이전에 계산된 배포 일수가 저장되지 않아서 여기서 추가한다
        
        // 4. 위 과정을 마무리한 후 결과 리스트 반환
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        System.out.println(new strategy_42586().solution(progresses, speeds));
    }
}