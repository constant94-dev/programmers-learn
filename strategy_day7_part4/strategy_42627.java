package strategy_day7_part4;

import java.util.*;

/**
 * strategy_42627
 * [힙(Heap)] 디스크 컨트롤러
 */
public class strategy_42627 {
    // 굳이 Job 클래스를 작성할 필요는 없지만 jobs[0][0] 접근보다 jobs[0].duration처럼 필드 이름으로
    // 데이터에 접근해 가독성을 높이는게 편하기 때문에 작성했다.
    private static class Job {
        public final int start;
        public final int duration;

        private Job(int start, int duration){
            this.start =start;
            this.duration = duration;
        }
    }

    public int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        for (int i=0; i<jobs.length; i++){
            jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));

        // 현재 시간이 아직 작업의 요청 시간에 도달하지 못한 작업들
        Deque<Job> q = new ArrayDeque<>(Arrays.asList(jobs));
        // 이미 요청 시간은 지났지만 아직 시작하지 못한 작업들
        PriorityQueue<Job> pq = new PriorityQueue<>(
            Comparator.comparingInt(job -> job.duration));
        
        int exec = 0; // 작업의 요청 시간부터 종료 시간까지 누적합을 나타내는 변수
        int time = 0; // 현재 시간을 나타내는 변수
        while (!q.isEmpty() || !pq.isEmpty()){
            while (!q.isEmpty() && q.peek().start <= time){
                pq.add(q.poll());
            }

            if (pq.isEmpty()){
                time = q.peek().start;
                continue;
            }

            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }

        return exec/jobs.length;  
    }  
}