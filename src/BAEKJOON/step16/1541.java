import java.util.*;
/**
 무조건 덧셈을 먼저하고 뺄셈을 하는 것이 제일 작은 수를 만들 수 있음.
*/

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // '-' 기호를 기준으로 나눔
    StringTokenizer st1 = new StringTokenizer(sc.nextLine(), "-");
    int[] arr = new int[st1.countTokens()];
    int temp = 0;
    int result = 0;
    int i = 0;

    while(st1.hasMoreTokens()){
      // '-' 연산자를 기준으로 나누어진 식을 계산해서 배열에 넣어줌
      StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
        while(st2.hasMoreTokens()){
            temp += Integer.parseInt(st2.nextToken());
        }
      arr[i++] = temp;
      temp = 0;
    }
    
    //만든 배열에서 첫번째 원소에서 나머지를 빼기
    result = arr[0];
    for(i=1;i<arr.length; i++){
      result -= arr[i];
    }
    System.out.println(result);
  }
}
