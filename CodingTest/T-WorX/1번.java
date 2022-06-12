import java.util.*;

class Solution {
    public int[] solution(int[] p) {
        int[] answer = new int[p.length];
        int i = 0;

        while(i < p.length){
            int minIdx = getMinIdx(p, i);

            if(i != minIdx){
                int temp = p[i];
                p[i] = p[minIdx];
                p[minIdx] = temp;

                answer[i]++;
                answer[minIdx]++;
            }

            i++;
        }

        return answer;
    }

    public static int getMinIdx(int[] p, int start){
        int min = 1001;
        int idx = 0;

        for(int i=start; i<p.length; i++){
            if(p[i] < min){
                min = p[i];
                idx = i;
            }
        }

        return idx;
    }
}
