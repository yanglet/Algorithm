import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reported = new HashMap<>(); // 신고 받은 횟수
        Map<String, Integer> result = new HashMap<>(); // 메일 받는 횟수
        
        report = Arrays.stream(report).distinct().toArray(String[]::new); // 중복 제거
        
        for(String s : report){
            String[] st = s.split(" ");
            reported.put(st[1], reported.getOrDefault(st[1], 0) + 1);
        }
        
        for(String s : report){
            String[] st = s.split(" ");
            int value = reported.get(st[1]); // st[1]가 신고 받은 횟수
            
            if(value >= k){ // st[1]가 신고 받은 횟수가 k 보다 크거나 같으면
                result.put(st[0], result.getOrDefault(st[0], 0) + 1); // st[0]이 메일받는 횟수 + 1 
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}
