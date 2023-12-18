package strategy_day7_part5;

import java.util.*;

/**
 * strategy_43163
 * [깊이/너비 우선 탐색(DFS/BFS)] 단어 변환
 */
public class strategy_43163 {
    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    private boolean isConvertable(String src, String dst){
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;
        for (int i=0; i<srcArr.length; i++){
            if (srcArr[i] != dstArr[i]) diff++;
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Deque<State> q = new ArrayDeque<>();
        q.add(new State(begin,0));

        while (!q.isEmpty()){
            State state = q.poll();

            if (state.word.equals(target)){
                return state.step;
            }

            for (int i=0; i<words.length; i++){
                String next = words[i];

                if (!isConvertable(state.word, next)){
                    continue;
                }

                if (isVisited[i]){
                    continue;
                }

                isVisited[i] = true;
                q.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }
}