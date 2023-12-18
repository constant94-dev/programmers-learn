package strategy_day7_part5;

import java.util.*;

/**
 * strategy_1844
 * [깊이/너비 우선 탐색(DFS/BFS)] 게임 맵 최단거리
 */
public class strategy_1844 {
    private static class State {
        public final int x;
        public final int y;
        public final int step;

        private State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};

    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];

        Deque<State> q = new ArrayDeque<>();
        q.add(new State(0,0,1));
        isVisited[0][0] = true;

        while (!q.isEmpty()){
            State state = q.poll();

            if (state.y == maps.length-1 && state.x == maps[state.y].length-1){
                return state.step;
            }

            for (int d = 0; d < 4; d++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if (ny<0 || ny>=maps.length || nx<0 || nx>=maps[ny].length){
                    continue;
                }

                if (maps[ny][nx] != 1){
                    continue;
                }

                if (isVisited[ny][nx]){
                    continue;
                }

                isVisited[ny][nx] = true;
                q.add(new State(nx,ny,state.step+1));
            }
        }

        return -1;
    }
}