package remind_24_07;

public class Remind_86491 {
    public int solution(int[][] sizes) {
        // 정렬된 가로,세로 배열 만들기 (더 큰 쪽을 가로로 배치)
        int sizesLength = sizes.length;
        for (int i=0; i<sizesLength; i++){
            if (sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        // 가로,세로 최대 크기 찾기
        int max_width = 0;
        int max_height = 0;
        for (int j=0; j<sizesLength; j++){
            if (max_width < sizes[j][0]) max_width = sizes[j][0];
            if (max_height < sizes[j][1]) max_height = sizes[j][1];
        }

        // 위에서 찾은 가로,세로 값으로 지갑 면적 계산
        return max_width * max_height;
    }

    public static void main(String[] args) {
        Remind_86491 test = new Remind_86491();
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };
        int result = test.solution(sizes);
        System.out.println(result);
    }
}
