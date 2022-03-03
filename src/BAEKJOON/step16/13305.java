import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] distance = new long[n-1];
    long[] cost = new long[n];
    long sum = 0;
    long min = 0; //이동하면서 cost의 최솟값

    for(int i=0; i<n-1; i++) distance[i] = sc.nextLong();
    for(int i=0; i<n; i++) cost[i] = sc.nextLong();

    min = cost[0];
    for(int i=0; i<n-1; i++){
      if(min > cost[i]){
        min = cost[i];
      }
      sum += (min * distance[i]);
    }
    System.out.println(sum);
  }
}
