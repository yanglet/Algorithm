import java.util.*;

public class Main {
  static int[] house;
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); //집의 개수
    int C = sc.nextInt(); //공유기의 개수
    house = new int[N];

    for(int i=0; i<N; i++){
      house[i] = sc.nextInt();
    }
    
    Arrays.sort(house); //정렬이 되어있어야 이분탐색가능

    int start = 1; //최소거리
    int end = house[N-1] - house[0] + 1; //최대거리
    
    while(start < end){
      int mid = (start + end) / 2;

      if(installCount(mid) < C){
        end = mid;
      }else{
        start = mid + 1;
      }
    }

    System.out.println(start - 1);
  }
  //인접한 공유기의 거리에 따른 설치할 수 있는 공유기 개수
  public static int installCount(int dist){
    int count = 1;
    int preLocate = house[0];

    for(int i=1; i<house.length; i++){
      int locate = house[i];

      if(locate - preLocate >= dist){
        count++;
        preLocate = locate;
      }
    }
    
    return count;
  }
}
