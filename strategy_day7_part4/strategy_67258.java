package strategy_day7_part4;

import java.util.*;

/**
 * strategy_67258
 * [2020 카카오 인턴십] 보석 쇼핑
 * 투 포인터: 구간을 나타내는 두 변수를 하나씩 뒤로 이동시켜 가면서 구간을 검사하는 알고리즘
 */
public class strategy_67258 {
    public int[] solution(String[] gems) {
        int start = 0;
        int end = gems.length-1;

        Set<String> gemSet = new HashSet<>(List.of(gems)); // 전체 보석 종류를 알기위한 자료구조

        int s = 0;
        int e = s;
        Map<String, Integer> includes = new HashMap<>(); // 한 종류의 보석이 구간 내 얼마나 많이 포함되는지 확인 변수
        includes.put(gems[s], 1);

        while (s < gems.length){ // 구간 반복의 시작점이 배열 범위를 벗어나면 종료
            if (includes.keySet().size() == gemSet.size()){ // 모든 보석이 포함된 경우
                if (e - s < end - start){ // 현재 발견한 구간[s,e]와 기존 구간[start,end]의 길이 비교 짧은 구간 선택
                    start = s;
                    end = e;
                }

                // 시작점을 뒤로 이동시켜 더 작은 구간을 검사
                includes.put(gems[s], includes.get(gems[s]) - 1);
                if (includes.get(gems[s]) == 0){
                    includes.remove(gems[s]); // 시작점에 있던 보석 제거
                }
                s++; // 시작점 증가
            } else if (e < gems.length-1) { // 구간 내 모든 보석이 포함 안됨
                e++; // 끝점 증가 구간을 늘린다
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else { // 배열 범위를 벗어나면 구간 검사 종료
                break;
            }
        }

        return new int[] {start + 1, end + 1};
    }
}