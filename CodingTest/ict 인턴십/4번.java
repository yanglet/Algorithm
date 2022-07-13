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
     * Complete the 'compressWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING word
     *  2. INTEGER k
     */

    public static String compressWord(String word, int k) {
        String result = word;
        int len = result.length();
        int temp = 1;
        
        for(int i=0; i<len - k + 1; i++){
            char c1 = result.charAt(i);
            
            for(int j=i+1; j<len; j++){
                char c2 = result.charAt(j);
                
                if(Character.compare(c1, c2) == 0){
                    temp++;
                }else{
                    break;
                } 
            }
            
            if(temp >= k){
                StringBuffer sb = new StringBuffer(result);
                sb.replace(i, i + temp, "");
                result = sb.toString();
                i = 0;
            }
            len = result.length();
            temp = 1;
        }

        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.compressWord(word, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
