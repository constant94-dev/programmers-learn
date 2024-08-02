package remind_24_08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Remind_42839 {
    private Set<Integer> completeNum = new HashSet<>();
    public int solution(String numbers) {
        int count = 0;
        // 모든 숫자 조합
        numCombi("", numbers);

        Iterator<Integer> it = completeNum.iterator();
        while (it.hasNext()){
            if (isPrime(it.next())){ // 소수 찾기
                count++;
            }
        }
        // 소수 개수 반환
        return count;
    }

    private boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1) return false;
        // 2. 에라토스테네스의 체의 limit을 계산
        int lim = (int) Math.sqrt(num);
        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인
        for (int i=2; i<=lim; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private void numCombi(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다 (빈 문자열은 숫자가 아니다)
        if (!comb.isEmpty()) completeNum.add(Integer.valueOf(comb));
        // 2. 남은 숫자 중 한개를 더해 새로운 숫자를 만든다
        for (int i=0; i<others.length(); i++){
            numCombi(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
    }

    public static void main(String[] args) {
        Remind_42839 test = new Remind_42839();
        String numbers = "011";
        int result = test.solution(numbers);
        System.out.println(result);
    }
}
