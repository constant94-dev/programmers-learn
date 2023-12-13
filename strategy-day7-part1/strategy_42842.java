/**
 * strategy_42842
 * [완전탐색] 카펫
 */
public class strategy_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 3. 카펫에 가로가 2거나, 세로가 2이면 중앙값이 없어 노란색을 쓸 수 없다.
        // 4. 위 조건으로 가로,세로는 3이상 이라는걸 알 수 있다.
        for (int width=3; width<=5000; width++){
            for (int height=3; height<=width; height++){
                // 1. 테두리 값 = 가로x2 + (세로-2)x2 => (가로+(세로-2))x2
                int boundary = (width+(height-2))*2;
                // 2. 중앙 값 = (가로x세로) - (테두리 값)
                int center = (width*height) - boundary;
                // 5. 테두리 값과 중앙 값이 입력된 brown과 yellow 와 같다면 해당 가로,세로 반환
                if (boundary == brown && center == yellow){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}