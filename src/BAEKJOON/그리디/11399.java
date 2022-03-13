import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
      FastReader fr = new FastReader();
      int n = fr.nextInt();
      int[] sum = new int[n]; //각 사람이 기다린시간
      int[] array = new int[n];
      int result = 0;
        
      for(int i = 0; i < n; i++){
          int x = fr.nextInt();
          array[i] = x;
      }
      Arrays.sort(array);
      for(int i = 0; i < n; i++){
          for(int j = 0; j <= i; j++){
              sum[i] += array[j]; 
          }
      }
      for(int i = 0; i < n; i ++) result += sum[i];
      
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