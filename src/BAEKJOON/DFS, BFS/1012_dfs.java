import java.util.*;
import java.io.*;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int count;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static ArrayList<Integer> countArr = new ArrayList<>();
  static int N;
  static int M;
  static int K;
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    int T = fr.nextInt();
    
    while(T-- > 0){
      StringTokenizer st = new StringTokenizer(fr.nextLine(), " ");
		  M = Integer.parseInt(st.nextToken()); //밭의 가로길이 -> 열
      N = Integer.parseInt(st.nextToken()); //밭의 세로길이 -> 행
      K = Integer.parseInt(st.nextToken()); //배추가 심어진 위치의 개수

      graph = new int[M][N];
      visited = new boolean[M][N];
      
      for(int i=0; i<K; i++){
        st = new StringTokenizer(fr.nextLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph[n][m] = 1;
      }

      count = 0;
      
      for(int i=0; i<M; i++){
        for(int j=0; j<N; j++){
          if(graph[i][j] == 1 && visited[i][j] == false){
            dfs(i, j);
            count++;
          }
        }
      }
      
      System.out.println(count);
    }
  }
  public static void dfs(int x, int y){
    visited[x][y] = true;

    //네 방향에 대해서
    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      
      if(nx >= 0 && ny >= 0 && nx < M && ny < N){
        if(graph[nx][ny] == 1 && visited[nx][ny] == false){
          dfs(nx, ny);
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
