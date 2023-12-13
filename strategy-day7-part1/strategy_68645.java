/**
 * strategy_68645
 * [월간 코드 챌린지 시즌1] 삼각 달팽이
 */
public class strategy_68645 {
    // 2. 위치 변화 배열 dx,dy 생성
    private static final int[] dx = {0,1,-1};
    private static final int[] dy = {1,0,-1};
    public int[] solution(int n) {
        // 1. 입력 값 n만큼 2차원 배열 생성
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0; // 아래:0, 오른쪽:1, 왼쪽위:2
        
        // 3. 숫자입력 무한 루프
        while(true){
            // 4. 삼각형 좌표 값의 1부터 삽입
            triangle[y][x] = v++;
            // 5. 아래, 오른쪽, 왼쪽 위 순으로 값 넣기
            int nx = x+dx[d];
            int ny = y+dy[d];
            // 5-1. 좌표를 벗어나거나 값이 0이 아닐 때 방향 수정
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                d = (d+1)%3; // 0,1,2만 반복됨
                nx = x+dx[d];
                ny = y+dy[d];
                // 5-2. 수정된 방향이 좌표를 벗어나거나 값이 0 아닐 때 종료
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }
        
        // 6. 2차원 배열 값을 1차원 배열에 담은 후 결과 리턴
        int[] answer = new int[v-1]; // v 변수는 입력 값 n 보다 1크기 때문에 -1을 수행한 배열을 생성
        int index = 0;
        
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                answer[index++] = triangle[i][j]; // ex. [0][0],[1][0],[1][1]
            }
        }
        
        return answer;
    }
}