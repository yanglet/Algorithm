import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> minPq = new PriorityQueue<>();
        Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            String[] sp = operation.split("\\s+");
            String op = sp[0];
            int num = Integer.parseInt(sp[1]);
            
            if(minPq.isEmpty() && op.equals("D")){
                continue;
            }
            
            if(op.equals("I")){
                minPq.offer(num);
                maxPq.offer(num);
            }else if(op.equals("D")){
                if(num < 0){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }else{
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            }
        }
        
        if( !minPq.isEmpty() ){
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }
        
        return answer;
    }
}
