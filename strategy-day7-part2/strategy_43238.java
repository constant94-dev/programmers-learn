import java.util.Arrays;

/**
 * strategy_43238
 * [이분탐색] 입국심사
 */
public class strategy_43238 {
    // 검사할 시간(t), 대기자 수(n), 각 심사관별 심사 소요 시간(times)
    private boolean isValid(long t, int n, int[] times){
        long c = 0;
        for (int time : times){ // 심사관별 심사 소요 시간 순회
            c += t/time; // 시간 't' 동안 처리할 수 있는 최대 심사 개수
        }
        return c>=n; // 최대 심사 개수가 대기자 수보다 많거나 같은지 반환
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        // 전체 범위를 포함할 수 있는 시작 값과 끝 값을 초기화
        long start = 1; // 심사하는데 걸리는 최소 시간
        long end = 1000000000000000000L; // 심사하는데 걸리는 최대 시간
        long answer = 1000000000000000000L; // 모든 사람이 심사를 받는 최소 시간 값 초기화
        

        while (end>=start) {
            long mid = (start+end)/2; // 범위를 절반으로 줄이기 위해서 중간 값을 계산

            if (isValid(mid,n,times)){
                answer = Math.min(answer,mid);
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.println(new strategy_43238().solution(n, times));
    }
}