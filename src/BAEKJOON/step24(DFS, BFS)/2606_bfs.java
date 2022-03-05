import java.util.*;

public class Main {
  static int N;
  static int M;
  static int count;
  static int[][] graph;
  static boolean[] visited;
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //컴퓨터의 수
    M = sc.nextInt(); //연결된 컴퓨터 쌍의 수
    count = 0;
    graph = new int[101][101];
    visited = new boolean[101];

    for(int i=0; i<M; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();

      graph[x][y] = graph[y][x] = 1;
    }
    
    bfs(1);
    
		System.out.println(count);
  }

  public static void bfs(int v){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(v); //시작 정점 넣어줘야함
    visited[v] = true;

    while( !queue.isEmpty() ){ //큐가 빌때까지
      v = queue.poll();
      for(int i=1; i<=N; i++){
        if(graph[v][i] == 1 && visited[i] == false){
          visited[i] = true;
          queue.offer(i);
          count++;
        }
      }
    }
  }
}
