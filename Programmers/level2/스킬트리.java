import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<s.length(); i++){
                String c = String.valueOf(s.charAt(i));
                if( skill.contains(c) ){
                    sb.append(c);
                }
            }
            
            String str = new String(sb);
            
            for(int i=skill.length(); i>=0; i--){
                String sk = skill.substring(0, i);
                if(sk.equals(str)){
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
