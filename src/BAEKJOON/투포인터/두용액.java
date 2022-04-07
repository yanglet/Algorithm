import java.util.*;
import java.io.*;

//백준 2470번 

public class Main {
  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int[] arr = new int[N];

    for(int i=0; i<N; i++){
      arr[i] = fr.nextInt();
    }

    Arrays.sort(arr);

    int start = 0;
    int end = N-1;
    int preValue = 2000000000;
    int preLeftIndex = 0;
    int preRightIndex = 0;

    while(start < end){
      int value = arr[end] + arr[start]; // 비교가 될 값 


      if(Math.abs(value) < preValue){
        preLeftIndex = start;
        preRightIndex = end;
        preValue = Math.abs(value);
      }
      
      if(value > 0){
        end--;
      }
      else{
        start++;
      }
    }

    System.out.println(arr[preLeftIndex] + " " + arr[preRightIndex]);
    
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
