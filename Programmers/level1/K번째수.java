import java.util.*;

// 정렬

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int n = 0;
        
        for(int[] a : commands){
            int i = a[0];
            int j = a[1];
            int k = a[2];
            
            int[] sArr = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(sArr);
            
            answer[n++] = sArr[k - 1];
        }
        
        return answer;
    }
}
