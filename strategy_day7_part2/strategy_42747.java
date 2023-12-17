package strategy_day7_part2;

import java.util.Arrays;

/**
 * strategy_42747
 * [정렬] H-Index
 */
public class strategy_42747 {
    // 인용된 논문 수로 H-Index 값을 찾기위한 기능
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h; // 'h'가 5라면 뒤에서 5번째 값이 5보다 크거나 같아야 한다
        return citations[index] >= h;
    }
    
    public int solution(int[] citations) {
        Arrays.sort(citations); // 모든 인용 횟수를 순회하지 않기 위한 오름차순 정렬
        
        for (int h=citations.length; h>=1; h--){ // 'h'는 발표한 논문 수를 넘을 수 없다.
            if (isValid(citations,h)) return h;
        }
        
        return 0; // 'h'를 1까지만 검사하고 리턴을 안하면 0을 리턴
    }
}