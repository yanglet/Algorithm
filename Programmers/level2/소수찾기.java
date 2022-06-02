import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        int answer = 0;
        
        comb("", numbers, 0);
        
        for(int num : set){
            if( isPrime(num) ){
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(int num){
        if(num == 1 || num == 0){
            return false;
        }
        
        for(int i=2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
    
    static void comb(String str, String numbers, int index){
        if(str != ""){
            set.add(Integer.parseInt(str));
        }
        
        if(index == numbers.length()){
            return;
        }
            
        for(int i=0; i<numbers.length(); i++){
            if( !visited[i] ){
                visited[i] = true;
                comb(str + numbers.charAt(i), numbers, index + 1);
                visited[i] = false;
            }
        }    
    }
}
