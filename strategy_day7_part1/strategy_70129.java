package strategy_day7_part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * strategy_70129
 * [월간 코드 챌린지 시즌1] 이진 변환 반복하기
 */
public class strategy_70129 {
        // 2. 입력된 s의 문자 '0'을 제거한다
    public String remove(String s){
        String removeStr = s.replaceAll("0","");
        return removeStr;
    }
    
    // 3. '0'이 제거된 문자열을 이진 변환한다
    public String transform(String removeS){
        List<Integer> binaries = new ArrayList<>();
        String transformStr = "";
        int mok = 0;
        int remainder = 0;
        int length = removeS.length();
        
        while (true){
            mok = length/2;
            remainder = length%2;
            binaries.add(remainder);
            
            if (mok == 0) break;
            length = mok;
        }
        Collections.reverse(binaries);
        
        for (int binary : binaries){
            transformStr += String.valueOf(binary);
        }
        
        return transformStr;
    }
    
    public int[] solution(String s) {
        // 1. 이진 변환 횟수, '0'을 제거한 횟수를 가지는 배열을 생성
        int[] answer = new int[2];
        String origin = s;
        String removeStr = "";
        String transformStr = "";
        
        // 4. 이진 변환의 값이 '1'일 때까지 2,3번 과정을 반복한다
        while(!transformStr.equals("1")){
            removeStr = remove(origin);
            transformStr = transform(removeStr);
            
            int zeroCount = origin.length() - removeStr.length();
            origin = transformStr;
            answer[1] += zeroCount;
            answer[0]++;
        }
        
        // 5. 지금까지 '0'을 제거한 수와 이진변환 횟수를 1차원 배열로 반환
        return answer;
    }
}