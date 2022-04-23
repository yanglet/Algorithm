import java.util.*;

class Solution {
    static Map<String, Boolean> visited = new HashMap<>();
    static int answer = 100;
    
    public int solution(String begin, String target, String[] words) {
        for(String s : words){
            visited.put(s, false);
        }
        
        dfs(begin, target, words, 0);
        
        if( !Arrays.asList(words).contains(target) ){
            return 0;
        }
        
        return answer;
    }
    
    // check == true 이면 방문
    public void dfs(String begin, String target, String[] words, int depth){
        if( target.equals(begin) ){
            answer = Math.min(answer, depth);
            return;
        }
        for(String s : words){
            if( !visited.get(s) && check(begin, s) ){
                visited.put(s, true);
                dfs(s, target, words, depth + 1);
                visited.put(s, false);
            }
        }
    }
    
    // begin 과 한 알파벳만 달라야함
    public boolean check(String begin, String word){
        char[] b = begin.toCharArray();
        char[] w = word.toCharArray();
        int count = 0;
        
        for(int i=0; i<b.length; i++){
            if(b[i] == w[i]){
                count++;
            }
        }
        
        return (count == word.length() - 1) ? true : false;
    }
}
