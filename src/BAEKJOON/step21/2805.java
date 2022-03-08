import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
    int N = fr.nextInt(); //나무의 개수
    int M = fr.nextInt(); //절단한 나무의 총길이(최소 길이)
    int result = 0;
    int[] arr = new int[N];
    
    for(int i=0; i<N; i++){
      arr[i] = fr.nextInt();
    }
    
    Arrays.sort(arr);
    
    int start = 0;
    int end = arr[N-1];
    
    while(start < end){
      long sum = 0;
      int mid = (start + end) / 2;
      for(int i=0; i<N; i++){
        if(arr[i] > mid){
          sum += (arr[i] - mid);
        }
      }
      if(sum < M){
        end = mid;
      }
      else{
        start = mid + 1;
      }
    }
    
    result = start - 1;

    System.out.println(result);
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
