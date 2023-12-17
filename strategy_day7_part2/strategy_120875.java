package strategy_day7_part2;

/**
 * strategy_120875
 * [코딩테스트 입문] 평행
 */
public class strategy_120875 {
    public int solution(int[][] dots) {
        int answer = 0;
        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = dots[1][0];
        int y2 = dots[1][1];
        int x3 = dots[2][0];
        int y3 = dots[2][1];
        int x4 = dots[3][0];
        int y4 = dots[3][1];

        double slopeOne = 0.0d;
        double slopeTwo = 0.0d;
        // 한 직선의 기울기 공식: (y2 - y1) / (x2 - x1)
        // 총 3가지 조합이 필요 (1,2 vs 3,4), (1,3 vs 2,4), (1,4 vs 2,3)
        slopeOne = (double)(y2-y1) / (x2-x1);
        slopeTwo = (double)(y4-y3) / (x4-x3);
        if (slopeOne == slopeTwo) answer = 1;

        slopeOne = (double)(y3-y1) / (x3-x1);
        slopeTwo = (double)(y4-y2) / (x4-x2);
        if (slopeOne == slopeTwo) answer = 1;

        slopeOne = (double)(y4-y1) / (x4-x1);
        slopeTwo = (double)(y3-y2) / (x3-x2);
        if (slopeOne == slopeTwo) answer = 1;
        // 위 과정을 마무리한 후 결과 리턴
        return answer;
    }
}