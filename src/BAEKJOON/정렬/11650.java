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
    int N = fr.nextInt();
    List<Point> list = new ArrayList<>();
    for(int i=0; i<N; i++){
      list.add(new Point(fr.nextInt(), fr.nextInt()));
    }
    Collections.sort(list, (a, b) -> a.getX() == b.getX() ? a.getY() - b.getY() : a.getX() - b.getX());

    for(int i=0; i<N; i++){
      Point p = list.get(i);
      System.out.println(p.getX() + " " + p.getY());
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
