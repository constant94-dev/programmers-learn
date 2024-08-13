package remind_24_08;

import java.util.ArrayDeque;
import java.util.Deque;

public class Remind_86971 {
    private int minDiff = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        // 1. 인접행렬을 사용해 현재 전력망 표시
        int[][] adjMatrix = new int[n+1][n+1];
        for (int[] wire : wires) {
            int aNode = wire[0];
            int bNode = wire[1];

            adjMatrix[aNode][bNode] = 1;
            adjMatrix[bNode][aNode] = 1;
        }

        for (int[] wire : wires) {
            int aNode = wire[0];
            int bNode = wire[1];

            int aNetworkSize = getNodeNetworkSize(adjMatrix, n, aNode, bNode); // 2. A,B 전력망 중 하나의 노드만 연결된 송전탑 수 구하기
            int bNetworkSize = n - aNetworkSize; // 3. 전체 송전탑 수 - 하나의 노드에 연결된 송전탑 수
            int diff = Math.abs(aNetworkSize - bNetworkSize); // 두 전력망 송전탑 수 차이

            minDiff = Math.min(minDiff, diff); // 4. 최솟값 갱신
        }

        // 5. 위 과정을 마무리 후 결과 반환
        return minDiff;
    }

    private int getNodeNetworkSize(int[][] adjMatrix, int n, int aNode, int bNode) {
        boolean[] visited = new boolean[n+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(aNode);
        visited[aNode] = true;

        int size = 0;
        while (!deque.isEmpty()){
            int node = deque.poll();
            size++;

            for (int neighbor = 1; neighbor<=n; neighbor++) {
                if (node == aNode && neighbor == bNode) continue;
                if (node == bNode && neighbor == aNode) continue;

                if (!visited[neighbor] && adjMatrix[node][neighbor] == 1) {
                    visited[neighbor] = true;
                    deque.offer(neighbor);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Remind_86971 test = new Remind_86971();
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };
        System.out.println("결과: " + test.solution(9, wires));
    }
}
