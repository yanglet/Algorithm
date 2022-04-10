import java.util.*;
import java.io.*;

//메모리 초과가 나넹
//백준 1753번 

public class Main {
  static final int INF = 100000000;
  static int[][] graph;
  static boolean[] visited;
  static int V;
  static int E;
  static int[] dist;
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    V = fr.nextInt(); // 정점의 개수
    E = fr.nextInt(); // 간선의 개수
    graph = new int[V + 1][V + 1]; // 그래프
    dist = new int[V + 1]; // 최단거리 배열
    visited = new boolean[V + 1];
    int start = fr.nextInt();

    for(int i=0; i<E; i++){
      int x = fr.nextInt();
      int y = fr.nextInt();
      
      graph[x][y] = fr.nextInt();
    }

    Arrays.fill(dist, INF); // 최단거리 배열 초기화
    init(start);
    
    dijkstra();

    for(int i=1; i<=V; i++){
      if( dist[i] == INF ){
        System.out.println("INF");
      }
      else{
        System.out.println(dist[i]);
      }
    }
    
  }

  public static void dijkstra(){

    //n-2번 반복 1번은 init()에서 처리
    for(int i=1; i<V-1; i++){
      int index = findMinIndex();
      visited[index] = true;
      
      for(int j=1; j<=V; j++){
        if( !visited[j] && graph[index][j] != 0 ){
          if(dist[j] > dist[index] + graph[index][j]){
            dist[j] = dist[index] + graph[index][j];
          }
        }
      }
    }
  }

  public static int findMinIndex(){
    int min = INF;
    int minIndex = -1;
    
    for(int i=1; i<=V; i++){
      
      if(min > dist[i] && !visited[i]){
        minIndex = i;
        min = dist[i];
      }
    }

    return minIndex;
  }

  public static void init(int start){
    for(int i=1; i<=V; i++){
      if(i == start){
        dist[start] = 0;
        visited[start] = true;
      }else{
        if(graph[start][i] != 0){
          dist[i] = graph[start][i];
        }
      }
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
