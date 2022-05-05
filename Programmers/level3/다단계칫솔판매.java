import java.util.*;

// 아오 왜 안되는겁니까 제발 살려주세요 하

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : enroll){
            map.put(s, Arrays.asList(enroll).indexOf(s)); // enroll 인덱스
        }
        
        for(String s : seller){ // 판매원 kid
            int i = Arrays.asList(seller).indexOf(s); // i
            String ref = referral[map.get(s)]; // 추천인 parent
            int cost = amount[i] * 100; // money
            
            while(true){ 
                answer[map.get(s)] += (cost - cost / 10);
                cost /= 10;
                
                if(cost == 0 || ref.equals("-")){
                    break;
                }
                
                s = ref;
                ref = referral[map.get(s)];
            }
        }
        
        return answer;
    }
}
