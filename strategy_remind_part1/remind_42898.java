package strategy_remind_part1;

import java.util.Arrays;

/**
 * remind_42898
 * [동적계획법(Dynamic Programming)] 등굣길
 */
public class remind_42898 {
    private final int[][] mems = new int[101][101];
    
    private int count(int x, int y, int w, int h, boolean[][] isPuddles){
        if (x>w || y>h) return 0; // 범위 검사
        if (isPuddles[x][y]) return 0; // 물웅덩이 검사
    
        if (mems[x][y] != -1) return mems[x][y]; // 경로 경우의 수가 있다면 그대로 반환
        if (x == w && y == h) return 1; // 학교 도착
        
        int total = count(x+1,y,w,h,isPuddles) + count(x,y+1,w,h,isPuddles); // 가능한 경로 누적
        return mems[x][y] = total%1000000007; // 나머지 반환
    }
    
    public int solution(int m, int n, int[][] puddles) {
        for (int[] mem : mems){
            Arrays.fill(mem,-1);
        }
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for (int[] puddle : puddles){
            isPuddle[puddle[0]][puddle[1]] = true;
        }
        
        return count(1,1,m,n,isPuddle);
    }
}