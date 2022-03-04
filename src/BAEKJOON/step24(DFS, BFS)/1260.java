import java.util.*;

class Main {
  static int N;
  static int M;
  static int start; //V
  static int[][] graph;
  static boolean[] visited;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    start = sc.nextInt(); //V
    graph = new int[1001][1001]; //1부터 시작
    visited = new boolean[1001]; //1부터 시작

    //정점 연결 -> 간선
    for(int i=0; i<M; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();

      graph[x][y] = graph[y][x] = 1;
    }
    dfs(start);

    Arrays.fill(visited, false); //다시 초기화
    System.out.println();

    bfs(start);
  }
  //재귀적으로 dfs 구현
  public static void dfs(int v){
    visited[v] = true;
    System.out.print(v + " ");
    //1부터 시작인것 주의
    for(int i=1; i<=N; i++){
      //간선이 있는지(정점끼리 연결되어있는지) && 방문한 정점인지 확인
      if(graph[v][i] == 1 && visited[i] == false){
        dfs(i);
      }
    }
  }

  //bfs구현
  public static void bfs(int v){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(v); //시작점도 Queue에 넣어줘야함
    visited[v] = true;
    System.out.print(v + " ");

    while( !queue.isEmpty() ){ // 큐가 빌때까지 반복
      v = queue.poll();
      //1부터인것 주의
      for(int i=1; i<=N; i++){
        //간선으로 연결된것중에 방문하지않은 정점에 대해서
        if(graph[v][i] == 1 && visited[i] == false){
          queue.offer(i);
          visited[i] = true;
          System.out.print(i + " ");
        }
      }
    }
  }
}