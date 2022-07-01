class Solution {
    public int solution(int[] A) {
        int answer = 0;
        if(A.length == 1){
            return 1;
        }
        for(int i=0; i<A.length - 1; i++){
            int idx1 = check(A, i);
            int idx2 = check(A, i + 1);

            if(idx1 < idx2){
                answer = Math.max(answer, idx1 - i + 2);
            }else{
                answer = Math.max(answer, idx2 - i + 2);
            }
        }
        return answer;
    }

    public static int check(int[] A, int idx){
        int value = A[idx];
        for(int i=idx; i<A.length; i+=2){
            if(i >= A.length - 2){
                if(A[A.length - 1] == value){
                    return A.length - 1;
                }
                if(A[A.length - 2] == value){
                    return A.length - 2;
                }
            }
            if(A[i] != value){
                return i - 2;
            }
        }
        return -1;
    }
}
