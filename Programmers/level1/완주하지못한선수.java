import java.util.*;

// 해시

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : participant){
            // 동명이인일 경우를 생각하기
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // 0이 아닌 사람이 완주를 못한 것.
        for(String s : completion){
            map.put(s, map.get(s) - 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer += key;
            }
        }
       
        return answer;
    }
}
