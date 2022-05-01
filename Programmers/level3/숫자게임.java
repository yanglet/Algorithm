import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++){
            int value = bS(A[i], A.length, B); // upperbound 이용
            
            if(B[value] > A[i]){
                answer++;
                B[value] = -1; // 탐색해서 가져온 원소는 지워줌
            }
        }
        
        return answer;
    }
    
    public static int bS(int value, int length, int[] B){
        int left = 0;
        int right = length - 1;
        
        while(left < right){
            int mid = (left + right) / 2;
            
            if(value < B[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}
