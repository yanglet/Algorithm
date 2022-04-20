import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == false){
                count++;
                dfs(i, computers);
            }
        }
        
        return count;
    }
    
    public void dfs(int start, int[][] computers){
        visited[start] = true;
        
        for(int i=0; i<visited.length; i++){
            if(computers[start][i] == 1 && visited[i] == false && start != i){
                dfs(i, computers);
            }
        }
    }
}
