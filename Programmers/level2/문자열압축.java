import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000;
        
        if(s.length() == 1){
            return 1;
        }
        
        for(int i=1; i<=s.length() / 2; i++){
            String sub = s.substring(0, i);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<=s.length(); j += i){
                String nextSub = s.substring(j, j < s.length() - i ? j + i : s.length());
                
                if( sub.equals(nextSub) ){
                    count++;
                }else{
                    String zip = count > 1 ? String.valueOf(count) + sub : sub;
                    sb.append(zip);
                    sub = nextSub;
                    count = 1;
                }
            }
            
            sb.append(sub);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
