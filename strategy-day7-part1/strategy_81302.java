/**
 * strategy_81302
 * [2021 카카오 채용연계형 인턴십] 거리두기 확인하기
 */
public class strategy_81302 {
    // 1. 상좌우하 형태의 dx, dy 위치 변화 배열을 생성
    private static final int[] dx = {0,-1,1,0};
    private static final int[] dy = {-1,0,0,1};
    
    // 4. 맨해튼 거리 1에 빈테이블이 있다면 빈테이블에 인접한 맨해튼 거리 2에 응시자가 있는지 확인하는 기능
    public boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for (int d=0; d<4; d++){
            if (d == exclude) continue; // 특정 응시자에 방향은 검사하지 않는다
            
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length) continue; // 맨해튼 거리 검사 범위가 대기실을 넘어가면 지나간다
            if (room[ny][nx] == 'P') return true; // 맨해튼 거리에 응시자가 있어 거리두기를 안지킨다
        }
        return false; // 맨해튼 거리에 응시자가 없어 거리두기를 지킨다
    }
    
    // 3. 대기실 내부에 특정 응시자가 거리두기를 지키고 있는지 확인하는 기능
    public boolean isDistanced(char[][] room, int x, int y){
        for (int d=0; d<4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length)
                continue; // 특정 응시자의 상하좌우가 대기실의 범위를 넘을 때 지나간다
            switch(room[ny][nx]){
                    case 'P': return false; // 특정 응시자는 거리두기를 안지킨다
                    case 'O':
                        if (isNextToVolunteer(room,nx,ny,3-d)) return false; // 특정 응시자의 맨해튼 거리를 확인, 거리두기 안지킨다
                        break;
            }
        }
        return true; // 특정 응시자는 거리두기를 지킨다
    }
    
    // 2. 대기실이 거리두기를 지키고 있는지 확인하는 기능
    public boolean isDistanced(char[][] room){
        for (int y=0; y<room.length; y++){
            for (int x=0; x<room[y].length; x++){
                if (room[y][x] != 'P') continue; // 응시자가 없으면 지난간다
                if (!isDistanced(room,x,y)) return false; // 해당 대기실은 거리두기 안지킨다
            }
        }
        return true; // 해당 대기실은 거리두기 지킨다
    }
    
    public int[] solution(String[][] places) {
        // 1-1. 결과 배열은 입력받은 2차원 배열 길이만큼 생성
        int[] answer = new int[places.length];
        
        for (int i=0; i<answer.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j=0; j<room.length; j++){ // 대기실 가공
                room[j] = place[j].toCharArray();
            }
            // 5. 위 기능을 수행한 후 해당 대기실이 거리두기를 지키면 1, 아니면 0 저장
            if (isDistanced(room)){
                answer[i] = 1; // 거리두기 지킨 대기실
            } else {
                answer[i] = 0; // 거리두기 안지킨 대기실
            }
        }
        
        return answer;
    }
}