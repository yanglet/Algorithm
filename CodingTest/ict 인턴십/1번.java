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
     * Complete the 'balancedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int balancedSum(List<Integer> arr) {
        int left = 0;
        int right = 0;
        int temp = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int j=0; j<1; j++){
            left += arr.get(j);
        }
            
        for(int j=arr.size() - 1; j>1; j--){
            right += arr.get(j);
        }
        
        if(left == right){
            if(temp > left){
                temp = left;
                idx = 1;
            }
        }
        
        for(int i=2; i<arr.size() - 2; i++){
            left += arr.get(i - 1);
            right -= arr.get(i);
            
            if(left == right){
                if(temp > left){
                    temp = left;
                    idx = i;
                }
            }
        }
        
        return idx;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.balancedSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
