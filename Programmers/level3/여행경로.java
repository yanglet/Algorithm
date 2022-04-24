import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    static List<String> temp = new ArrayList<>();
    public List<String> solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        temp.add("ICN"); // 초기값은 무조건 ICN
        
        dfs("ICN", tickets, 0);
        
        return answer;
    }
    
    public void dfs(String start, String[][] tickets, int count){
        if(answer.size() > 0){ // answer에 원소가 있다는 것 -> 이미 티켓을 다 쓴 경로가 있다.
            return;
        }
        
        if(count == tickets.length){ // 티켓을 모두 다 썼다면 answer에 경로 담기
            for(String s : temp){
                answer.add(s);   
            }
            return;
        }
        
        int index = 0;
        for(String[] s : tickets){
            if( s[0].equals(start) && visited[index] == false ){
                temp.add(s[1]);
                visited[index] = true;
                dfs(s[1], tickets, count + 1);
                visited[index] = false;
                temp.remove(temp.size() - 1);
            }
            index++;
        }
    }
}
