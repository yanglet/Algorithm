import java.util.*;
import java.io.*;

// 백준 11053번 

public class Main {

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int[] A = new int[N];  // 입력받는 배열
    int[] dp = new int[N]; // 각 원소까지의 증가하는 부분 수열의 수

    for(int i=0; i<N; i++){
      A[i] = fr.nextInt();
    }

    for(int i=0; i<N; i++){
      dp[i] = 1;

      // i 보다 작은 원소에 대하여 dp[i] 계산
      for(int j=0; j<i; j++){

        if(A[j] < A[i] && dp[i] < dp[j] + 1){
          dp[i] = dp[j] + 1;
        }
      }
    }

    Arrays.sort(dp);

    System.out.println(dp[N-1]);
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
