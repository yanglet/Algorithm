import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int totalPrice = sc.nextInt();
    int[] coins = new int[n];
    int count = 0;

    for(int i=0; i<n; i++){
      coins[i] = sc.nextInt();
    }
    
    int j = n-1;
    while(totalPrice != 0){
      if(coins[j] <= totalPrice){
        totalPrice -= coins[j];
        count++;
      }else j--;
    }
    System.out.println(count);
  }
}
