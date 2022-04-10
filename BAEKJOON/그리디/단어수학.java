import java.util.*;
import java.io.*;

/**
* 백준 1339번 문제
* 단어를 이렇게 생각 -> BAC = B*100 + A*10 + C*1
* 카운팅정렬을 이용해서 저 자릿수 (100, 10, 1)
* 이런식으로 더한 후 정렬하고 개수가 많은 알파벳 부터
* 높은 수를 주어 곱해줌
*/

public class Main {
  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int[] count = new int[26];
    int num = 0;

    for(int i=0; i<N; i++){
      String s = fr.nextLine();

      num = (int) Math.pow(10, s.length() - 1);
      
      for(int j=0; j<s.length(); j++){
        count[s.charAt(j) - 'A'] += num;
        num /= 10;
      }
    }

    Arrays.sort(count);
    int k = 9;
    int result = 0;
    
    for(int i=25; i > 16; i--){
      result += count[i] * k--;
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
