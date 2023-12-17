package strategy_day7_part3;

import java.util.Arrays;

/**
 * strategy_43105
 * [동적계획법(Dynamic Programming)] 정수 삼각형
 */
public class strategy_43105 {
    private final int[][] mem = new int[501][501]; // 결과 값을 저장할 dp 삼각형
    
    private int max(int x, int y, int[][] triangle){ // 아래, 우측아래 연산 값 중 큰 값 찾기
        if (y==triangle.length) return 0; // max 재귀를 타다가 다시 복귀 시작
        if (mem[x][y] != -1) return mem[x][y]; // max 재귀를 타다가 복귀 시작할 때 연산 결과 반환
        
        return mem[x][y] = triangle[y][x] + Math.max(
        max(x,y+1,triangle),
        max(x+1,y+1,triangle));
    }
    
    public int solution(int[][] triangle) {
        for (int[] row:mem){
            Arrays.fill(row,-1); // dp 삼각형 -1로 채우기
        }
        
        return max(0,0,triangle);
    }
}