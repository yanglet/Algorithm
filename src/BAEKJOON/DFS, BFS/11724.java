import java.util.*;
import java.io.*;


public class Main {
  static int N;
  static int M;
  static boolean[] visited;
  static int[][] graph;
  static int count = 0;

  
  public static void main(String[] args) {
    FastReader fr = new FastReader();

    N = fr.nextInt();
    M = fr.nextInt();
    visited = new boolean[N+1];
    graph = new int[N+1][N+1];
    
    for(int i=0; i<M; i++){
      int x = fr.nextInt();
      int y = fr.nextInt();

      graph[x][y] = graph[y][x] = 1;
    }

    for(int i=1; i<=N; i++){
      if(visited[i] == false){
        dfs(i);
        count++;        
      }
    }

    System.out.println(count);
  }

  public static void dfs(int start){
    visited[start] = true;
    int v = start;

    for(int i=1; i<=N; i++){
      if(graph[v][i] == 1 && visited[i] == false){
        visited[i] = true;
        dfs(i);
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
