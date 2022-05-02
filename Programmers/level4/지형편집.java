import java.util.*;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        int[] arr = getArr(land);
        long min = arr[0];
        long max = arr[1];
        
        // 블럭 높이 기준으로 이분탐색
        while(min <= max){
            long mid = (min + max) / 2;
            
            long cost1 = getCost(land, mid + 1, P, Q);
            long cost2 = getCost(land, mid, P, Q);
            
            // mid + 1 의 높이에서의 비용이 작다면 mid 까지는 최소가 될 수 없음
            if(cost1 < cost2){
                answer = cost1;
                min = mid + 1;
            }else{
                answer = cost2;
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    public long getCost(int[][] land, long height, int P, int Q){
        long cost = 0;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land.length; j++){
                long temp = land[i][j] - height;
                    
                if(temp > 0){ // 삭제
                    cost += temp * Q;
                }else{ // 추가
                    cost += temp * P * -1;
                }
            }
        }
        
        return cost;
    }
    
    public int[] getArr(int[][] land){
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land.length; j++){
                max = Math.max(land[i][j], max);
                min = Math.min(land[i][j], min);
            }
        }
        
        int[] arr = {min, max};
        
        return arr;
    }
}
