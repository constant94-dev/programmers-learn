import java.util.Arrays;

/**
 * strategy_42898
 * [동적계획법(Dynamic Programming)] 등굣길
 */
public class strategy_42898 {
    private final int[][] mem = new int[101][101]; // 최대 격자 크기 초기화
    
    private int count(int x, int y, int w, int h, boolean[][] isPuddle){
        if (x>w || y>h) return 0; // 격자 범위를 벗어나면 반환
        if (isPuddle[y][x]) return 0; // 물 웅덩이를 만나면 반환
        
        if (mem[x][y] != -1) return mem[x][y]; // 이미 거쳤던 경로는 반환
        if (x==w && y==h) return 1; // 학교에 도착했을 때 경로 하나 발견 반환
        
        int total = count(x+1, y, w, h, isPuddle)
            + count(x, y+1, w, h, isPuddle);
        
        return mem[x][y] = total % 1000000007; // 결과를 기억하기 위해 메모제이션에 저장
    }
    
    public int solution(int m, int n, int[][] puddles) {
        for (int[] row:mem){ // 격자 값 초기화
            Arrays.fill(row,-1);
        }
        
        boolean[][] isPuddle = new boolean[n+1][m+1]; // 전체 격자 생성
        for (int[] p:puddles){ // 물 웅덩이 만들기
            isPuddle[p[1]][p[0]] = true;
        }
        
        return count(1,1,m,n,isPuddle); // 집부터 학교까지 재귀 탐색
    }
}