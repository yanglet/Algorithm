import java.util.*;
import java.io.*;

// 백준 1987

public class Main {
  static int[][] graph;
  static boolean[] visited = new boolean[26]; // 알페벳 숫자만큼
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int R, C; // 세로가 R, 가로가 C
  static int max = 0; 

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    R = fr.nextInt();
    C = fr.nextInt();
    graph = new int[R][C];

    for(int i=0; i<R; i++){
      String s = fr.nextLine();
      
      for(int j=0; j<C; j++){
        // 0 ~ 25의 숫자로 알파벳 저장
        graph[i][j] = s.charAt(j) - 'A';
      }
    }

    dfs(0, 0, 1);    

    System.out.println(max);
  }

  public static void dfs(int x, int y, int count){
    Point p = new Point(x, y);
    visited[graph[p.getX()][p.getY()]] = true; 

    max = Math.max(max, count);
    
    for(int i=0; i<4; i++){
      int nx = dx[i] + p.getX();
      int ny = dy[i] + p.getY();

      if(nx >= 0 && ny >= 0 && nx < R && ny < C){
        if(visited[graph[nx][ny]] == false){
          dfs(nx, ny, count + 1);

          // 빙문했던 곳을 다시 false로 설정
          // 이 경로가 제일 길다는 보장이 없으므로
          visited[graph[nx][ny]] = false;
        }
      }
    }
  }

  public static class Point {
    int x; 
    int y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }

    public int getX(){
      return this.x;
    }

    public int getY(){
      return this.y;
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
