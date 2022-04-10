import java.util.*;
import java.io.*;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int N;
  static int M;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    StringTokenizer st = new StringTokenizer(fr.nextLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N][M];
    visited = new boolean[N][M];

    for(int i=0; i<N; i++){
      String s = fr.nextLine();
      for(int j=0; j<M; j++){
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    bfs();
    
    System.out.println(graph[N-1][M-1]);
  }

  public static void bfs(){
    Queue<Point> queue = new LinkedList<Point>();
    queue.offer(new Point(0, 0));
    visited[0][0] = true;

    while( !queue.isEmpty() ){
      Point point = queue.poll();
      int x = point.getX();
      int y = point.getY();    

      for(int i=0; i<4; i++){
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        
        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
          if(graph[nextX][nextY] == 1 && visited[nextX][nextY] == false){
            queue.offer(new Point(nextX, nextY));
            visited[nextX][nextY] = true;
            graph[nextX][nextY] += graph[x][y];
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
