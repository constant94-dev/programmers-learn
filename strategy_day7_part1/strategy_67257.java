package strategy_day7_part1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * strategy_67257
 * [2020 카카오 인턴] 수식 최대화
 *  1차 아이디어
    * 1. 입력된 문자열에서 수식만을 골라낸 배열을 생성
    * 2. 입력된 문자열을 순회
    * 3. 순회하며 수식을 만나면 이전값과 다음값을 해당 수식으로 연산
    * 4. 연산된 문자열로 다시 순회
    * 5. 순회하며 수식을 만나면 이전값과 다음값을 해당 수식으로 연산
    * 6. 위 과정을 반복하고 수식이 없을 때 남은 값을 절대값형태로 리스트에 저장
    * 7. 리스트에 저장된 가장 큰 값을 결과로 리턴
 */
public class strategy_67257 {
    private static final String[][] precedences = { // 연산자 우선순위 총 경우의수가 6개 고정!
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };
    
    private long calculate(long lhs, long rhs, String op){ // 연산자 왼쪽,오른쪽 값을 연산
        return switch (op){
                case "+" -> lhs + rhs;
                case "-" -> lhs - rhs;
                case "*" -> lhs * rhs;
                default -> 0;
        };
    }
    
    // 피연산자와 연산자 문자열 리스트, 연산자 우선순위 경우의 수 한개 배열을 연산
    private long calculate(List<String> tokens, String[] precedence){
        for (String op : precedence){
            for (int i=0; i<tokens.size(); i++){
                if (tokens.get(i).equals(op)){ // 연산자 한개씩 돌아가며 문자열 리스트에서 탐색
                    long lhs = Long.parseLong(tokens.get(i-1)); // 연산자 기준 왼쪽 피연산자
                    long rhs = Long.parseLong(tokens.get(i+1)); // 연산자 기준 오른쪽 피연산자
                    long result = calculate(lhs,rhs,op);
                    tokens.remove(i-1); // 연산에 사용된 값 제거
                    tokens.remove(i-1); // 연산에 사용된 값 제거
                    tokens.remove(i-1); // 연산에 사용된 값 제거
                    tokens.add(i-1,String.valueOf(result)); // 연산에 사용된 값 제거 후 결과 값을 맨 앞으로 이동
                    i-=2; // 순회하는 인덱스 또한 앞으로 당긴다 (세번 당기고 하나 넣었으니 2계단 앞으로)
                }   
            }
        }
        return Long.parseLong(tokens.get(0)); // 모든 연산자 계산 후 남은 하나의 숫자 반환
    }
    
    
    public long solution(String expression) {
        // *-+ 연산자를 문자열에서 제거하지 않고 그대로 사용하고 싶으면 StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(expression,"+-*",true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken()); // 피연산자와 연산자를 리스트에 추가
        }
        
        long max = 0;
        for (String[] precedence:precedences){ // 정의한 연산자 경우의 수 하나씩 반복
            long value = Math.abs(calculate(new ArrayList<>(tokens),precedence)); // 절대값 변환
            if (value > max){
                max = value;
            }
        }
        
        return max;
    }
}