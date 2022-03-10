import java.util.*;

public class Main {
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    
    String s = Integer.toString(A * B * C);
    
    int[] count = new int[10];

    for(int i=0; i<s.length(); i++){
      count[s.charAt(i) - '0']++;
    }
    
    for(int i=0; i<10; i++){
      System.out.println(count[i]);    
    }
  }
}
