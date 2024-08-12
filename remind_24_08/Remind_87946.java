package remind_24_08;

import java.util.Arrays;

public class Remind_87946 {
    private int maxDungeon = 0;

    public int solution(int k, int[][] dungeons) {
        // 1. 각 행의 방문자 생성
        boolean[] visited = new boolean[dungeons.length];

        // 2. 각 행의 경우의 수로 던전 탐험
        runDungeon(k, dungeons, visited, 0);

        // 4. 가장 큰 결과 반환
        return maxDungeon;
    }

    private void runDungeon(int k, int[][] dungeons, boolean[] visited, int count) {
        /* 던전 탐험 순서
         * 1-2-3 or 1-3-2 or 2-1-3 or 2-3-1 or 3-1-2 or 3-2-1
         * 1-2-3-4 or 1-2-4-3 or 1-3-2-4 or 1-3-4-2 or 1-4-2-3 or 1-4-3-2 ...
         * */
        int dungeonLength = dungeons.length;
        for (int i=0; i<dungeonLength; i++){
            System.out.println("visited: "+ Arrays.toString(visited) + "\tcount: "+count);
            if (visited[i] || k < dungeons[i][0]) continue;

            visited[i] = true; // 현재 던전 탐험 표시
            runDungeon(k-dungeons[i][1], dungeons, visited, count+1);
            visited[i] = false; // 다음 던전 탐험을 위한 표시 제거
        }
        // 3. 던전 탐험 최대 값 갱신
        maxDungeon = Math.max(maxDungeon, count);
    }

    public static void main(String[] args) {
        Remind_87946 test = new Remind_87946();
        int[][] dungeons = {
                {80,20},
                {50,40},
                {30,10}
        };
        int result = test.solution(80, dungeons);
        System.out.println(result);
    }
}
