package strategy_remind_part1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * remind_43162
 * [깊이/너비 우선 탐색(DFS/BFS)] 네트워크
 */
public class remind_43162 {
    // dfs 구현
    private void visitAll(int computer, int[][] computers, boolean[] visited){
        // 큐 생성
        Deque<Integer> stack = new ArrayDeque<>();
        // 큐 초기값 세팅
        stack.push(computer); // 0번 네트워크부터 추가

        // 큐가 비어있을 때까지 순회
        while (!stack.isEmpty()){
            int c = stack.pop();
            
            if (visited[c]) continue; // 재방문 검사
            visited[c] = true;
            
            // 현재 네트워크와 다음번 네트워크를 순회
            for (int next=0; next<computers.length; next++){
                if (c == next || computers[c][next] == 0) continue; // 본인 네트워크가 아니거나 연결된 네트워크가 없거나
                stack.push(next); // 스택에 넣어 전이
            }
            
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i=0; i<n; i++){
            if (visited[i]) continue; // 방문한 네트워크는 지나간다
            visitAll(i,computers,visited); // dfs 호출
            answer++; // 네트워크 수 증가
        }
        
        // 위 과정을 마무리 후 네트워크 수 리턴
        return answer;
    }
}