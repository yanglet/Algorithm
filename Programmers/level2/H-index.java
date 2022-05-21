import java.util.*;

/**
* 내림차순 정렬을 함
* arr[i] 번 이상 인용된 논문의 개수 = i + 1
* 나머지 논문은 arr[i] 번 이하 인용된 것이 보장됨 ( 내림차순 이므로 )
*/

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        
        for(int i=0; i<citations.length; i++){
            if(arr[i] < i + 1){
                return i;
            }
        }
        
        return answer;
    }
}
