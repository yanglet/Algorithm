import java.util.*;
/**
 작은 막대를 움직이면 가로의 길이도 움직임
*/
class Solution {
    public int solution(int[] histogram) {
        int left = 0;
        int right = histogram.length - 1;
        int maxValue = 0;

        // 투 포인터
        while(left < right){
            // 비교값
            int value = (right - left - 1) * Math.min(histogram[left], histogram[right]);

            if(maxValue < value){
                maxValue = value;
            }

            // 막대가 작은 경우 다른 막대로 바꾸어 본다
            if(histogram[left] <= histogram[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxValue;
    }
}
