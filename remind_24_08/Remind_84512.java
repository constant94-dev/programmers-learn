package remind_24_08;

import java.util.ArrayList;
import java.util.List;

public class Remind_84512 {
    private List<String> dics = new ArrayList<>(); // 1. 단어 사전 리스트 초기화
    private String[] vowel = {"A","E","I","O","U"}; // 1. 알파벳 모음 초기화

    public int solution(String word) {
        // 2. 모음으로 이루어진 단어사전 만들기
        makeToDictionary("",0);
        // 3. 찾고자 하는 단어의 인덱스 가져오기
        int index = findToIndex(word);
        // 4. 가져온 인덱스+1 반환
        return index+1;
    }

    private void makeToDictionary(String alpha, int length) {
        // 재귀 사용
        // 시작 값: 만들어야 할 시작 단어
        // 종료 조건: 단어 길이가 5일 경우 return
        // 점화식 (점차적으로 종료에 가까워지는 식)
        // 시작 단어에 모음 하나 붙인 값, 현재 조합한 단어 길이
        if (length >= 5) return;

        for (String s : vowel) {
            final String generate = alpha + s;
            dics.add(generate);
            makeToDictionary(generate, length+1);
        }
    }

    private int findToIndex(String word) {
        if (dics.contains(word)) return dics.indexOf(word);
        return -1;
    }

    public static void main(String[] args) {
        Remind_84512 test = new Remind_84512();
        String word = "AAAE";

        System.out.println(test.solution(word));
    }
}
