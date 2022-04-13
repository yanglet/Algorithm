class Solution {  
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int result){
        if(depth == numbers.length){
            if(target == resultv){
                answer++;
                return; // 바로 종료하도록
            }
        }else{
            dfs(numbers, depth + 1, target, result - numbers[depth]);
            dfs(numbers, depth + 1, target, result + numbers[depth]);
        }
    }
}
