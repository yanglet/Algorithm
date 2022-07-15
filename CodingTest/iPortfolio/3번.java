import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 100001;
        int temp = 0;
        int num = n;

        if(n % Math.sqrt(n) == 0){
            return 1;
        }

        // 그리디
        for(int i = (int) Math.sqrt(n); i>0; i--){
            int j = i;

            while(num > 0){
                int pow = j * j;

                if(num >= pow){
                    num -= pow;
                    temp++;
                }else{
                    j--;
                }
            }

            answer = Math.min(answer, temp);

            temp = 0;
            num = n;
        }

        return answer;
    }
}
