import java.util.*;
import java.io.*;

public class Main {
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    int N = fr.nextInt();

    Queue<Integer> pQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for(int i=0; i<N; i++){
      int x = fr.nextInt();

      if(x > 0){
        pQ.offer(x);
      }
      else{ // x == 0
        if( pQ.isEmpty() ){
          System.out.println(0);
        }else{
          System.out.println(pQ.poll());
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