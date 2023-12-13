import java.util.ArrayList;
import java.util.List;

/**
 * strategy_84512
 * [완전탐색] 모음사전
 */
public class strategy_84512 {
    private static final char[] CHARS = "AEIOU".toCharArray();
    // 1. 'AEIOU' 단어 사전을 만든다.
    private void generate(String word, List<String> words){ //상태, 종료조건, 점화식이 중요!!
        words.add(word);
        
        if (word.length() == 5) return; // 종료조건: 길이가 5인 word 멈춰!
        for (char c : CHARS){
            generate(word+c,words); // 상태: 이제 붙일 단어, 현재까지 붙인 단어 리스트
                                    // 점화식: word+(word+'A')+(word+'E')+(word+'I')+(word+'O')+(word+'U')
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        
        List<String> words = new ArrayList<>();
        generate("",words); // 결과는 {"","A","AA","AAA"...}
        // 2. 단어 사전을 탐색하며 입력된 단어 word 와 비교
        // 3. 단어 사전에서 같은 단어를 발견하면 해당 index 저장
        answer = words.indexOf(word); // 0번째 인덱스로 인해 밀린 번호를 찾는다
        
        return answer;
    }
}