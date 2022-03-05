import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
 
		FastReader fr = new FastReader();
		
		int N = fr.nextInt();
    int[] count = new int[10001]; //

    for(int i=0; i<N; i++){
      count[fr.nextInt()]++;
    }

    StringBuilder sb = new StringBuilder();
    
    for(int i=1; i<=10000; i++){
      if(count[i]-- != 0){
        sb.append(i--).append("\n");
      }
    }

    System.out.println(sb);
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
