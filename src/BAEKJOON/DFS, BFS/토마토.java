import java.util.*;
import java.io.*;

// 백준 7576번 문제

public class Main {
  static int[][] graph;
  static int N;
  static int M;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    M = fr.nextInt(); // 가로칸의 수 = 열의 개수
    N = fr.nextInt(); // 세로칸의 수 = 행의 개수
    graph = new int[N][M];

    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        graph[i][j] = fr.nextInt();
      }
    }

    bfs();
    
  }

  public static void bfs(){
    Queue<Point> q = new LinkedList<Point>();
    int day = 0;

    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(graph[i][j] == 1){
          q.offer(new Point(i, j, day));
        }
      }
    }
    
    while( !q.isEmpty() ){
      Point p = q.poll();
      day = p.day;

      for(int i=0; i<4; i++){
        int nextX = p.x + dx[i];
        int nextY = p.y + dy[i];

        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
          if(graph[nextX][nextY] == 0){
            graph[nextX][nextY] = 1;
            q.offer(new Point(nextX, nextY, day+1));
          }
        }
      }
    }

    if( check() ){
      System.out.println(day);
    }
    else{
      System.out.println(-1);
    }
  }

  public static boolean check(){
    
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        // 안익은 토마도가 있음
        if(graph[i][j] == 0){
          return false;
        }
      }
    }
    // 토마토가 모두 다 익음
    return true;
  }

  public static class Point {
    int x;
    int y;
    int day;

    public Point(int x, int y, int day){
      this.x = x;
      this.y = y;
      this.day = day;
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
