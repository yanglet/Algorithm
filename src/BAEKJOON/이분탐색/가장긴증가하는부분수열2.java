import java.util.*;
import java.io.*;

// 백준 12015번 문제
// 가장 긴 증가하는 부분 수열1 문제와 달리
// 범위가 N (1 ≤ N ≤ 1,000,000) -> nlogn 의 시간복잡도를 가져야함

public class Main {

  public static void main(String[] args) {
    FastReader fr = new FastReader();

    int N = fr.nextInt();
    int[] A = new int[N];  // 입력받는 배열
    // 가장 긴 증가하는 부분 수열을 만들어 가기 위한 ArrayList
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<N; i++){
      A[i] = fr.nextInt();
    }

    list.add(A[0]); // 맨 앞에 비교 값 추가

    // 모든 원소에 대해 증가하면 리스트에 추가
    // 그렇지 않으면 이분탐색으로 적절한 위치에 원소를 대체해줌
    //  ㄴ> 대체한다고 해서 수열의 개수가 변화하지 않음
    for(int i=1; i<N; i++){
      int value = A[i];

      // 리스트의 끝 원소 (현재 제일 큰 원소) 와 비교
      if(value > list.get(list.size() - 1)){
        list.add(value);
      }
      else{
        int left = 0;
        int right = list.size();

        while(left < right){
          int mid = (left + right) / 2;

          if(value <= list.get(mid)){
            right = mid;
          }
          else{
            left = mid + 1;
          }
        }

        list.set(left, value);
      }
    }

    System.out.println(list.size());
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
