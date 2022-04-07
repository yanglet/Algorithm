import java.util.*;
import java.io.*;

/**
* 백준 1300번 문제
* 0. 배열을 만들면 메모리 초과가 난다. 모든 수를 담아서 처리할 수 없다.
* 1. A 배열을 구구단으로 볼 수 있음
* 2. 각 i 단 (1단, 2단, 3단) 에서 임의의 x 보다 작거나 같은 수의 개수는 x / i 가 됨
* 3. 각 단에서의 임의의 x 보다 작은 수의 개수는 N과 같거나 작음 (당연히 각 단에 수의 개수가 N이니까)
* 4. x를 mid로 잡고 이분탐색을 하면서 count를 더해줌
* 5. count가 K보다 크거나 같다면 B[K]의 작거나 같은 수가 x(mid)의 작거나 같은 수가 많다
*             ( B[k] 보다 x(mid)가 더 크다. 더 오른쪽에 있다.)
*  ㄴ> right를 작게해줌 
* 6. 반대의 경우 left를 크게 해줌
*/

public class Main {

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int K = fr.nextInt();

    long left = 1;
    long right = K;

    // lowerBound 이용
    while(left < right){
      long mid = (left + right) / 2;
      long count = 0;

      // mid 보다 작거나 같은 수의 개수 (N을 초과할 수 없음)
      for(int i=1; i<=N; i++){
        count += Math.min(mid / i, N);
      }

      // B[K] 보다 x(mid)가 더 크다. 더 오른쪽에 있다.
      if(K <= count){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }

    System.out.println(left);
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
