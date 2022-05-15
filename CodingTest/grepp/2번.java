/**
  91.3 점 ,, 테스트14, 20 두 개가 통과가 안됨
  전체적으로 보면
  1, 2, 3번은 풀만한듯한데 4번은 어케 풀어야할지 감도 안옴
  5, 6번 sql도 풀만함
  
  근데 집중이 안돼서 이거만 하다가 나옴
*/

class Solution {
    public int solution(int[] bricks, int n, int k) {
        int answer = 0;
        int count = 1;

        while(count != k){
            int index = getNextIdx(bricks);

            answer += n - bricks[index];

            bricks[index] = -1;

            count++;
        }
        
        return answer;
    }

    public static int getNextIdx(int[] bricks){
        int result = 0;
        int idx = -1;

        for(int i=0; i<bricks.length; i++){
            if(result <= bricks[i]){
                if(i > 0 && i < bricks.length - 1){
                    if(bricks[i + 1] == -1 || bricks[i - 1] == -1){
                        continue;
                    }else{
                        idx = i;
                        result = bricks[i];
                    }
                }else{
                    continue;
                }
            }
        }

        return idx;
    }
}
