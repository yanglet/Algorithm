import java.util.*;

// 완전탐색

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int ans1 = 0, ans2 = 0, ans3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(a1[i % a1.length] == answers[i]){
                ans1++;
            }
            if(a2[i % a2.length] == answers[i]){
                ans2++;
            }
            if(a3[i % a3.length] == answers[i]){
                ans3++;
            }
        }
        
        int max = Math.max(Math.max(ans1, ans2), ans3);
        
        if(ans1 == max){
            answer.add(1);
        }
        if(ans2 == max){
            answer.add(2);
        }
        if(ans3 == max){
            answer.add(3);
        }
        
        return answer;
    }
}
