import java.util.*;
import java.io.*;

// 백준 1644번 

public class Main {

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    boolean[] prime = new boolean[N+1];

    // N 보다 작은 소수의 리스트 만들기
    // 에라토스테네스의 체
    for(int i=2; i*i<=N; i++){
      if(!prime[i]){
        for(int j=(i*i); j<=N; j+=i){
          prime[j] = true;
        }
      }
    }
    for(int i=2; i<=N; i++){
      if(!prime[i]){
        numbers.add(i);
      }
    }

    int start = 0;
    int end = 0;
    int result = 0;
    
    while(end != numbers.size()){
      int sum = 0;

      for(int i=start; i<=end; i++){
        sum += numbers.get(i);
      }      
      
      if(sum == N){
        result++;
      }
      
      if(sum <= N){
        end++;
      }
      else{
        start++;
      }
    }

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
