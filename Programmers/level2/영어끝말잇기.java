import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> preList = new ArrayList<>();

        int index = 0;
        for(String s : words){
            
            if(index > 0){
                String pre = preList.get(index - 1);
                
                if( pre.charAt(pre.length() - 1) != s.charAt(0) ){
                    answer[0] = person(n, index);
                    answer[1] = num(n, index);
                    break;
                }else if( preList.contains(s) ){
                    answer[0] = person(n, index);
                    answer[1] = num(n, index);
                    break;
                }
            }
            
            preList.add(s);
            index++;
        }

        return answer;
    }
    
    public static int person(int n, int index){
        if( (index + 1) % n == 0 ){
            return n;
        }else{
            return (index + 1) % n;
        }
    }
    
    public static int num(int n, int index){
        if( (index + 1) % n == 0 ){
            return (index + 1) / n;   
        }else{
            return (index + 1) / n + 1;
        }
    }
}
