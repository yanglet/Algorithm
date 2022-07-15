class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isOpen = new boolean[n + 1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=n; j+=i){
                if(isOpen[j] == true){
                    isOpen[j] = false;
                }else{
                    isOpen[j] = true;
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(isOpen[i]){
                answer++;
            }
        }

        return answer;
    }
}
