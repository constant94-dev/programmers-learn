package remind_24_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Remind_42840 {
    public int[] solution(int[] answers) {
        // 수포자 3명의 정답을 가지고 있는 2차원 배열 생성
        int[][] patterns = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        // 2차원 배열 길이만큼 순회하며 수포자 점수 저장
        int[] scores = {0,0,0};
        int ansLength = answers.length;
        int patternsLength = patterns.length;
        for (int numAns = 0; numAns < ansLength; numAns++){
            for (int numPattern = 0; numPattern < patternsLength; numPattern++){
                if (answers[numAns] == patterns[numPattern][numAns % patterns[numPattern].length]){
                    scores[numPattern]++;
                }
            }
        }

        // 수포자 점수 중 높은 점수 명단 작성
        int max_score = Arrays.stream(scores).max().orElse(0);
        List<Integer> result = new ArrayList<>();
        for (int person=0; person<3; person++){
            if (max_score <= scores[person]) {
                result.add(person+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Remind_42840 test = new Remind_42840();
        int[] answers = {5,5,5,5,5};
        int[] result = test.solution(answers);
        System.out.println(Arrays.toString(result));
    }
}
