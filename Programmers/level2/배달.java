import java.util.*;

class Solution {
    static final int INF = 10000000;
    static int[] d;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        d = new int[N + 1];
        visited = new boolean[N + 1];
        
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int[] r : road){
            int x = r[0];
            int y = r[1];
            int z = r[2];
            
            // x 에서 y 까지 가는 거리(비용)이 z이다. 
            // 양방향이기 때문에 둘다 담아줘야함
            graph.get(x).add(new Node(y, z));
            graph.get(y).add(new Node(x, z));
        }
        
        dijkstra(1);
        
        for(int i=1; i<=N; i++){
            System.out.println(d[i]);
            if(d[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    
    public static void dijkstra(int start){
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.getDist() - o2.getDist());
        Arrays.fill(d, INF);
        
        d[start] = 0;
        pq.offer(new Node(start, 0));
    
        while( !pq.isEmpty() ){
            int now = pq.poll().getIndex();
            
            if( visited[now] == false ){
                visited[now] = true;
                
                for(Node node : graph.get(now)){
                    int dist = d[now] + node.getDist();
                    
                    if(d[node.getIndex()] > dist){
                        d[node.getIndex()] = dist;
                        pq.offer(new Node(node.getIndex(), d[node.getIndex()]));
                    }
                }
            }
        }
    }
    
    public static class Node{
        int index; 
        int dist;
        
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        
        public int getIndex(){
            return this.index;
        }
        
        public int getDist(){
            return this.dist;
        }
    }
}
