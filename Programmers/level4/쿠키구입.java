class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for(int i=0; i<cookie.length-1; i++){
            int leftSum = cookie[i];
            int left = i;
            int rightSum = cookie[i + 1];
            int right = i + 1;
            
            while(true){
                if(leftSum == rightSum && answer < leftSum){
                    answer = leftSum;
                }
                if(leftSum <= rightSum && left > 0){
                    leftSum += cookie[--left];
                }else if(leftSum >= rightSum && right < cookie.length - 1){
                    rightSum += cookie[++right];
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}
