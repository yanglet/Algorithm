class Solution {
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        int userNum = periods.length;
        int[] totalPayments = new int[userNum];
        int[] nextTotalPayments = new int[userNum];

        for(int i=0; i<userNum; i++){
            for(int j=0; j<12; j++){
                totalPayments[i] += payments[i][j];
                if(j > 0){
                    nextTotalPayments[i] += payments[i][j];
                }
            }
        }

        for(int i=0; i<userNum; i++){
            nextTotalPayments[i] += estimates[i];
        }

        for(int i=0; i<userNum; i++){
            int period = periods[i] / 12;
            int nextPeriod = (periods[i] + 1) / 12;

            if(isVip(totalPayments[i], period) == false && isVip(nextTotalPayments[i], nextPeriod) == true){
                answer[0]++;
            }else if(isVip(totalPayments[i], period) == true && isVip(nextTotalPayments[i], nextPeriod) == false){
                answer[1]++;
            }
        } 

        return answer;
    }

    public static boolean isVip(int totalPayment, int period){
        if(period < 2){
            return false;
        }else if(period < 5){
            if(totalPayment >= 900000){
                return true;
            }else{
                return false;
            }
        }else{
            if(totalPayment >= 600000){
                return true;
            }else{
                return false;
            }
        }
    }
}
