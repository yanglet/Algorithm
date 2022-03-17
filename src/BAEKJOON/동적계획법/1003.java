import java.util.*;
import java.io.*;

public class Main {
  static List<Point> list = new ArrayList<>();
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    int T = fr.nextInt();
    int[] N = new int[T];

    for(int i=0; i<T; i++){
      N[i] = fr.nextInt();
    }

    for(int i=0; i<T; i++){
      int temp = N[i];
      init(temp);
      Point temp_p = list.get(temp);
      System.out.println(temp_p.getX() + " " + temp_p.getY());
      list = new ArrayList<Point>();
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

  public static void init(int n){
    for(int i=0; i<=n; i++){
      if(i == 0){
        list.add(new Point(1, 0));
      }
      if(i == 1){
        list.add(new Point(0, 1));
      }
      if(i > 1){
        Point p1 = list.get(i-1);
        Point p2 = list.get(i-2);

        list.add(new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY()));
      }
    }
  }


  // 0 -> 0 1번 출력, 1 0번 출력
  // 1 -> 0 0번 출력, 1 1번 출력
  // 2 -> 0 1번 출력, 1 1번 출력
  // 3 -> 0 1번 출력, 1 2번 출력
  // 4 -> 0 2          3
  // 5 -> 0 3          5
  // 6 -> 0 5          8

    
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