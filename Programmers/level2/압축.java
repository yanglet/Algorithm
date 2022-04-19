import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<26; i++){
            char a = (char) (90 - i);
            map.put(String.valueOf(a), 26 - i);
        }
        
        for(int i=0; i<msg.length(); i++){
            char w = msg.charAt(i);
            String s = String.valueOf(w);
            
            if( map.containsKey(s) ){
                int j = i;
                while( j < msg.length() - 1 ){
                    char c = msg.charAt(j++ + 1);
                    String temp = s + String.valueOf(c);

                    if( !map.containsKey(temp) ){
                        map.put(temp, map.size() + 1);
                        break;
                    }else{
                        s += String.valueOf(c);
                    }
                }
                i += s.length() - 1;
                answer.add(map.get(s));
            }
        }
        
        return answer;
    }
}
