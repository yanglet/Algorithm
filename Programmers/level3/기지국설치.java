class Solution {
    static int check = 0; // 현재까지 전파가 전달되는 위치
    static int answer = 0;
    public int solution(int n, int[] stations, int w) {
        
        for(int i=0; i<stations.length; i++){
            if(check >= n){
                break;
            }
            
            int left = stations[i] - (w + 1);
            int right = stations[i] + w;
            int dist = left - check;
            
            if(dist > 0){
                install(dist, stations[i], w);
            }else{
                check = stations[i] + w;
            }
            
            if(i == stations.length - 1 && check < n){
                dist = n - right;
                install(dist, stations[i], w);
            }
        }

        return answer;
    }
    
    public static void install(int dist, int station, int w){
        int a = dist / (w * 2 + 1);
        int b = dist % (w * 2 + 1);
        
        if(b > 0){
            answer += a + 1;
            check = station + w;
        }else{
            answer += a;
            check = station + w;
        }
    }
}
