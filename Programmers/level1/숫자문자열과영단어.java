import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(String number : numbers){
            if(s.contains(number)){
                s = s.replace(number, String.valueOf(Arrays.asList(numbers).indexOf(number)));
            }
        }
        
        answer = Integer.valueOf(s);
        
        return answer;
    }
}
