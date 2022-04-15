import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Job> jobs = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            jobs.offer(new Job(progresses[i], speeds[i]));
        }
        
        while( !jobs.isEmpty() ){
            int deployCnt = 0;
            
            for(Job job : jobs){
                job.doIt();
            }
            
            while( !jobs.isEmpty() && jobs.peek().isDone() ){
                jobs.poll();
                deployCnt++;
            }
            
            if(deployCnt > 0){
                answer.add(deployCnt);
            }
        }
        
        return answer;
    }
    
    public static class Job {
        int progress;
        int speed;
        
        public Job(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        
        public boolean isDone(){
            if(this.progress >= 100){
                return true;
            }
            return false;
        }
        
        public void doIt(){
            this.progress += this.speed;
        }
    }
}