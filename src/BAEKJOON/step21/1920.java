import java.util.*;
/**
if(Arrays.binarySearch(arr, key)  >= 0) -> 이렇게 라이브러리 함수를 사용해도 됨
*/

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] sorted = new int[n];
    for(int i=0; i<n; i++) sorted[i] = sc.nextInt();
    int m = sc.nextInt();
    int[] arrM = new int[m];
    for(int i=0; i<m; i++) arrM[i] = sc.nextInt();
    int[] result = new int[m];
    Arrays.sort(sorted); //정렬이 되어있어야 이분탐색이 가능

    for(int i=0; i<m; i++){
      if(binarySearch(sorted, arrM[i]) >= 0) result[i]=1;
      else result[i]=0;      
    }
    for(int i=0; i<m; i++){
      System.out.println(result[i]);
    }
  }
  public static int binarySearch(int[] arr, int key) {

	int left = 0;					// 탐색 범위의 왼쪽 끝 인덱스
	int right = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스

		// left right보다 커지기 전까지 반복한다.
	while(left <= right) {
 
		int center = (left + right) / 2;	//중간위치를 구한다.
 
		// key값이 중간 위치의 값보다 작을 경우
		if(key < arr[center]) {
			right = center - 1;
		}
		// key값이 중간 위치의 값보다 클 경우
		else if(key > arr[center]) {
			left = center + 1;
		}
		// key값과 중간 위치의 값이 같을 경우
		else {
			return center;
		}
	}
  return -1;
  }
}