import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
		int K = fr.nextInt(); //갖고있는 랜선 수
    int N = fr.nextInt(); //만들어야할 랜선 수
    
    int[] arr = new int[K];
    
    for(int i=0; i<K; i++){
      arr[i] = fr.nextInt();
    }
    
    Arrays.sort(arr);

    long min = 0;
    //long으로 캐스팅 해주지 않으면 입력받는 자연수의 범위가 int의 최댓값까지 이므로 overflow일어남
    long max = (long) arr[K-1] + 1;
    long mid = 0;

    while(min < max){
      mid = (min + max) / 2;

      long count = 0;
  
      for(int i=0; i<K; i++){
        count += (arr[i] / mid);
      }

      if(count < N){
        max = mid;
      }
      else{
        min = mid + 1;
      }
    }

    System.out.println(min - 1);
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
