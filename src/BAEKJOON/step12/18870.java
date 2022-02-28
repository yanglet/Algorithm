import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int num = fr.nextInt();
        int[] arr = new int[num]; //정렬할 배열
        int[] origin = new int[num]; //원래 값을 갖는 배열
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<num; i++){
            int x = fr.nextInt();
            arr[i] = x;
            origin[i] = x;
        }
        Arrays.sort(arr);
        
        int j = 0;
        for(int i=0; i<num; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], j);
                j++;
            }
        }
        //System.out.println 을 쓰면 시간초과가 남
        StringBuilder sb = new StringBuilder();
        for(int key : origin){
            sb.append(map.get(key)).append(' ');
        }
        System.out.println(sb);
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