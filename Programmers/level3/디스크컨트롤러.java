import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int pre = 0; // 직전 작업이 종료된 시간
        int count = 0; // 수행된 작업 수
        int i = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        Queue<Job> q = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        
        while(count < jobs.length){
            while(i < jobs.length && jobs[i][0] <= pre){
                q.offer(new Job(jobs[i][0], jobs[i][1]));
                i++;
            }
            
            if( q.isEmpty() ){
                pre = jobs[i][0];
            }else{
                Job job = q.poll();
                answer += pre + job.end - job.start;
                pre += job.end;
                count++;
            }
        }
        
        return answer / jobs.length;
    }
    
    public static class Job{
        int start;
        int end;
        
        public Job(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
