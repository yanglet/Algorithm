import java.util.*;
import java.io.*;

public class Main {
  
	public static void main(String[] args) {
		FastReader fr = new FastReader();
    int N = fr.nextInt();
    int[] arr = new int[N];

    for(int i=0; i<N; i++){
      arr[i] = fr.nextInt();
    }

    int x = fr.nextInt();

    Arrays.sort(arr);

    int count = 0;
    int start = 0;
    int end = N-1;

    while(start < end){
      int sum = arr[start] + arr[end];
      
      if(start >= 0 && start != end && end <= N-1){
        if(sum == x){
          count++;
        }
        if(sum <= x){
          start++;
        }
        else {
          end--;
        }
      }
    }

    System.out.println(count);
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