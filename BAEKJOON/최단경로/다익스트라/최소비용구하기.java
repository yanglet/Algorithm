import java.util.*;
import java.io.*;

// 백준 1916번 문제

public class Main {
  static final int INF = 100000000; 
  static int N, M, start, end;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[] dist;
  static boolean[] visited;

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    N = fr.nextInt();
    M = fr.nextInt();

    dist = new int[N + 1];
    visited = new boolean[N + 1];
    
    for(int i=0; i<N+1; i++){
      graph.add(new ArrayList<Node>());
    }

    for(int i=0; i<M; i++){
      int x = fr.nextInt();
      int y = fr.nextInt();
      int z = fr.nextInt();

      // x 부터 y 까지의 거리(비용)가 z이다
      graph.get(x).add(new Node(y, z));
    }

    start = fr.nextInt();
    end = fr.nextInt();

    dijkstra_q(start, end);
  }

  //우선순위 큐를 이용
  public static void dijkstra_q(int start, int end){
    Queue<Node> q = new PriorityQueue<>( (o1, o2) -> o1.getDist() - o2.getDist() );
    Arrays.fill(dist, INF);
    
    q.offer(new Node(start, 0));
    dist[start] = 0;

    while( !q.isEmpty() ){
      int now = q.poll().getIndex();

      // 현재 정점을 방문 했는지 확인
      if( visited[now] == false ){
        visited[now] = true;

        // 정점과 연결된 정점들에 대해서 최소 거리(비용) 계산
        for(Node node : graph.get(now)){
          // now까지 비용 + now에서 node.getIndex()까지 비용 ( now 를 거쳐가능 비용 )
          int cost = dist[now] + node.getDist();

          // node.getIndex() 까지의 원래 비용과 비교해서 작은 값으로 수정
          if(visited[node.getIndex()] == false && dist[node.getIndex()] > cost){
            dist[node.getIndex()] = cost;
            q.offer(new Node(node.getIndex(), dist[node.getIndex()]));
          }
        }
      }
    }

    System.out.println(dist[end]);
  }

  // 이건 왜 안될까? 테스트 케이스는 통과하는데,,
  public static void dijkstra(int start, int end){
    Arrays.fill(dist, INF);
    
    dist[start] = 0;
    visited[start] = true;

    // 시작 정점 기준으로 거리(비용) 초기화
    for(Node node : graph.get(start)){
      dist[node.getIndex()] = node.getDist();
    }

    // N-1번 반복 ( 초기화 했으니까 -1번 )
    for(int i=0; i<N-1; i++){
      int now = getSmallestNode();
      visited[now] = true;

      // 정점과 연결된 정점들에 대해서 최소 거리(비용) 계산
      for(Node node : graph.get(now)){
        // now까지 비용 + now에서 node.getIndex()까지 비용 ( now 를 거쳐가능 비용 )
        int cost = dist[now] + node.getDist();

        // node.getIndex() 까지의 원래 비용과 비교해서 작은 값으로 수정
        if(cost < dist[node.getIndex()]){
          dist[node.getIndex()] = cost;
        }
      }
    }

    System.out.println(dist[end]);
  }
  // 방문하지 않은 정점 중 dist(거리)가 제일 작은 노드찾기
  public static int getSmallestNode(){
    int min = INF;
    int index = 0;
    
    for(int i=1; i<=N; i++){
      if(dist[i] <= min && visited[i] == false){
        min = dist[i];
        index = i;
      }
    }
    
    return index;
  }

  // index 까지의 거리(비용)이 dist 이다. 
  public static class Node{
    private int index;
    private int dist;

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

  
  public static class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
    String next() {
      while (st == null || !st.hasMoreElements()) {
        try { st = new StringTokenizer(br.readLine()); }
        catch (IOException e) { e.printStackTrace(); }
      }
            return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
  }
}
