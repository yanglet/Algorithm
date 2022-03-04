import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<N; i++){
          arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //정렬되어 있어야 이분탐색이 가능 !!!!
        int M = sc.nextInt();
      
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
          int target = sc.nextInt();
          sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(" ");
        }
        System.out.println(sb);
      }
    public static int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length; //right이 길이임 주의*
        while(left < right){
            int mid = (left+right) / 2;
            //target값을 가진 인덱스중 최저 인덱스를 구하기위함
            if(target <= arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length; //right이 길이임 주의*
        while (left < right) {
            int mid = (left + right) / 2;
            //target값 보다 큰 값의 바로 다음 인덱스를 구하기위함
            if (target < arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
