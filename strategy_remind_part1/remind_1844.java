package strategy_remind_part1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * remind_1844
 * [깊이/너비 우선 탐색(DFS/BFS)] 게임 맵 최단거리
 */
public class remind_1844 {
    private static class State { // x,y 좌표를 편하게 사용하기 위한 내부 클래스 생성
        public final int x;
        public final int y;
        public final int step;
        
        private State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    private static final int[] dx = {1,0,-1,0};
    private static final int[] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        // 스택 생성
        Deque<State> stack = new ArrayDeque<>();
        // 스택 초기 세팅
        stack.add(new State(0,0,1));
        visited[0][0] = true;
        // DFS 구현
        while (!stack.isEmpty()){
            State st = stack.pop();
            
            // 상대 진영(맵의 끝 좌표)에 도착하면 현재까지 step 수 반환
            if (st.x == maps.length-1 && st.y == maps[st.x].length-1){
                return st.step;
            }
            
            for (int d=0; d<4; d++){
                int nx = st.x + dx[d];
                int ny = st.y + dy[d];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[nx].length) continue; // 범위 검사
                if (maps[nx][ny] != 1) continue; // 벽 검사
                if (visited[nx][ny]) continue; // 방문 검사
                
                
                visited[nx][ny] = true;
                stack.add(new State(nx,ny,st.step+1));
            }
        }
        
        return -1; // 위 과정을 마무리 후 상대 진영에 도착 못하면 -1
    }
}