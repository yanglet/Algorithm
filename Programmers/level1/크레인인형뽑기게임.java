import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int line = moves[i] - 1;
            
            for(int j=0; j<board.length; j++){
                int doll = board[j][line];
                
                if(doll > 0){
                    if( !s.empty() ){
                        System.out.println(s.peek());
                        if(s.peek() == doll){
                            answer += 2;
                            s.pop();
                        }else{
                            s.push(doll);
                        }
                    }else{
                        s.push(doll);   
                    }
                    board[j][line] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
