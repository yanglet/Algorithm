class Solution {
    public long solution(long w, long h) {
        long answer = 0;
        
        // 기울기가 h/w 인 1차 방정식의 해에서 내림하면 사용할 수 있는 사각형만 남음
        for(int i=0; i<w; i++){
            answer += i * h/w * 2;
        }
        
        return answer;
    }
}
