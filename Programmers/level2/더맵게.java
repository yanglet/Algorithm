import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        boolean ok = false;
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        while( pq.size() > 1 ){
            int newScoville = pq.poll() + (pq.poll() * 2);
            pq.offer(newScoville);
            answer++;
            
            if(pq.peek() < K){
                ok = false;
            }else{
                ok = true;
                break;
            }
        }
        
        return ok ? answer : -1;
    }
}
