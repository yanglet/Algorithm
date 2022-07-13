import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getLargestNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING num as parameter.
     */

    public static String getLargestNumber(String num) {
        int len = num.length();
        String result = num;
        int temp = 1;
        
        // 연속으로 짝수 또는 홀수인 구간 찾기
        // 그 구간에서 내림차순으로 정렬
        for(int i=0; i<len; i++){
            List<Integer> list = new ArrayList<>();
            String st = "";
            String a = String.valueOf(result.charAt(i));
            list.add(Integer.valueOf(a));
            
            for(int j=i+1; j<len; j++){
                String b = String.valueOf(result.charAt(j));
                if( (Integer.valueOf(a) % 2 == 0 && Integer.valueOf(b) % 2 == 0) || (Integer.valueOf(a) % 2 != 0 && Integer.valueOf(b) % 2 != 0) ){
                    list.add(Integer.valueOf(b));
                    temp++;
                }else{
                    break;
                }
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            for(Integer n : list){
                st += String.valueOf(n);
            }
            
            if(temp >= 2){
                StringBuffer sb = new StringBuffer(result);
                sb.replace(i, i + temp, st);
                result = sb.toString();
                i += temp - 1;
            }
            
            temp = 1;
        }
        
        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String num = bufferedReader.readLine();

        String result = Result.getLargestNumber(num);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
