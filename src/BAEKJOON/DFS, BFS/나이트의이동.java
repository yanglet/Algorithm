import java.util.*;
import java.io.*;

// 백준 7562번 문제

public class Main {
  // graph가 0이면 방문 x 0 이상이면 방문
  // graph의 값이 그 지점까지의 이동 수
  static int[][] graph;
  // 나이트의 8가지 경우를 계산하기 위한 배열
  static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  static int N;

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int T = fr.nextInt(); // 테스트 케이스

    for(int i=0; i<T; i++){
      N = fr.nextInt(); // 체스판의 한 변의 길이
      Point start = new Point(fr.nextInt(), fr.nextInt());
      Point end = new Point(fr.nextInt(), fr.nextInt());

      graph = new int[N][N];

      bfs(start);

      // 처음 1을 
      System.out.println(graph[end.getX()][end.getY()] - 1);
    }
  }

  public static void bfs (Point start){
    Queue<Point> q = new LinkedList<Point>();
    graph[start.getX()][start.getY()] = 1;
    q.offer(start);

    while( !q.isEmpty() ){
      Point p = q.poll();
      
      for(int i=0; i<8; i++){
        int nx = p.getX() + dx[i];
        int ny = p.getY() + dy[i];

        if(nx >= 0 && ny >= 0 && nx < N && ny < N){
          if(graph[nx][ny] == 0){
            graph[nx][ny] = graph[p.getX()][p.getY()] + 1;
            q.offer(new Point(nx, ny));
          }
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
