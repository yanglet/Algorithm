// 효율성 통과 못함
class Solution {
    public int solution(int[] estimates, int k) {
        int answer = 0;

        for(int i=0; i<estimates.length - k + 1; i++){
            int temp = 0;

            for(int j=i; j<k+i; j++){
                temp += estimates[j];
            }

            if(temp > answer){
                answer = temp;
            }
        }

        return answer;
    }
}
