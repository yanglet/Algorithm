import java.util.*;
import java.io.*;

//백준 1806번 

public class Main {
  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int S = fr.nextInt(); 
    int[] arr = new int[N + 1];
    int sum = 0;

    for(int i=0; i<N; i++){
      arr[i] = fr.nextInt();
    }

    int start = 0;
    int end = 0;
    int min = 100001;

    while(start <= N && end <= N){
      if( sum >= S && min > end - start ){
        min = end - start;
      }
      
      if(sum < S){
        sum += arr[end++];
      }
      else{
        sum -= arr[start++];
      }
    }

    if(min == 100001){
      System.out.println(0);
    }
    else{
      System.out.println(min);
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
