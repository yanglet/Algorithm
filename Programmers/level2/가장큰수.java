import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        // o2.compareTo(o1) 으로 하면 통과x
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if( arr[0].equals("0") ){
            return "0";
        }
        
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }   
        
        return answer;
    }
}
