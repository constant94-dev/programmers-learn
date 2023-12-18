package strategy_day7_part5;

import java.util.Comparator;
import java.util.Arrays;

/**
 * strategy_42884
 * [탐욕법(Greedy)] 단속카메라
 */
public class strategy_42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int count = 0;
        int last = Integer.MIN_VALUE;
        for (int[] route:routes){ // 단속 카메라 설치하기 위해 모든 이동 경로 순회
            // 직전에 설치한 단속 카메라가 경로에 포함되면
            // 해당 경로는 이미 단속 카메라를 만났기 때문에 추가 설치 안함
            if (last >= route[0] && last <= route[1]) continue;
            // 단속 카메라를 만나지 못한 이동 경로는 이동 경로의 끝 지점에 단속 카메라 설치 후
            // 단속 카메라 수 증가
            last = route[1];
            count++;
        }

        return count;
    }
}