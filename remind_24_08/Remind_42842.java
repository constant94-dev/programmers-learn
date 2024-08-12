package remind_24_08;

import java.util.Arrays;

public class Remind_42842 {
    private final int[] answer = new int[2];

    public int[] solution(int brown, int yellow) {
        int carpet = brown + yellow;
        // 1. 가로와 세로 크기는 3이상
        for (int height=3; height<carpet; height++){
            final int width = carpet/height;

            if (width < 3) continue;

            if (width >= height) {
                // 2. 노란색 카펫 너비 구하기 (가로-2)*(세로-2)
                if (isYellowArea(width, height, yellow)){
                    break;
                }
            }
        }

        // 3. 계산된 노란색 카펫 너비와 노란색 카펫 개수와 같으면 결과 반환
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private boolean isYellowArea(int width, int height, int yellow) {
        final int yellowArea = (width-2)*(height-2);
        if (yellowArea == yellow) {
            answer[0] = width;
            answer[1] = height;

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Remind_42842 test = new Remind_42842();
        test.solution(24, 24);
    }
}
