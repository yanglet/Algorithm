import java.util.*;
import java.io.*;

public class Main {
  static int[][] homeMap;
  static boolean[][] visited;
  static int N;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  //단지 크기 계산할  변수
  static int count = 0;
  //단지 크기를 추가해줄 배열
  static ArrayList<Integer> countArr = new ArrayList<>();
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
    N = fr.nextInt(); //지도의 크기

    homeMap = new int[N][N];
    visited = new boolean[N][N];

    for(int i=0; i<N; i++){
      String s = fr.nextLine();
      for(int j=0; j<N; j++){
        homeMap[i][j] = s.charAt(j) - '0';
      }
    }

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(homeMap[i][j] == 1 && visited[i][j] == false){
          count = 1;
          dfs(i, j);
          countArr.add(count);
        }
      }
    }
    
    Collections.sort(countArr);
    System.out.println(countArr.size());
    for(int i : countArr){
      System.out.println(i);
    }
  }
    

  public static int dfs(int x, int y){
    visited[x][y] = true;

    //동서남북 4가지 방향에 대하여
    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      //배열의 인덱스를 넘어가면 안됨
      if(nx>=0 && ny>=0 && nx<N && ny<N){
        if(homeMap[nx][ny] == 1 && visited[nx][ny] == false){
          dfs(nx, ny);
          count++;
        }
      }
    }
    return count;
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
