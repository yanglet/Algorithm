import java.util.*;
import java.io.*;

// 백준 1715번 문제

public class Main {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    
    int N = fr.nextInt();
    Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
    int result = 0;

    for(int i=0; i<N; i++){
      q.offer(fr.nextInt());
    }

    if(N == 1){
      System.out.println(0);
    }
    else{
      while( !q.isEmpty() ){
        if( q.size() == 1 ){
          break;
        }
        
        int x = q.poll();
        int y = q.poll();

        result += (x + y);
        q.offer(x + y);
      }

      System.out.println(result);
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
