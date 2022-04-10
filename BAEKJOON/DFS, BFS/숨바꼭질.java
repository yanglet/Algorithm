import java.util.*;

// 백준 1697번 문제

public class Main {
  static int[] located = new int[100001];
  static int N;
  static int K;
  static int[] dx = {-1, 1, 0}; //0이면 두배
  static boolean check;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt(); // 현재 위치
    K = sc.nextInt(); // 찾을 위치
    
    bfs(N);
  }

  public static void bfs(int start){
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(start);
    located[start] = 1;

    if(start == K){
      System.out.println(0);
      return;
    }
    
    while( !q.isEmpty() ){
      int v = q.poll();
      
      for(int i=0; i<3; i++){
        int nextLocated = v;
        
        if(dx[i] == 0 && v <= 50000){
          nextLocated = nextLocated * 2;
        }
        else{
          nextLocated = nextLocated + dx[i];
        }

        if(nextLocated == K){
          System.out.println(located[v]);
          return;
        }

        if(nextLocated >= 0 && nextLocated <= 100000){
          if(located[nextLocated] == 0){
            q.offer(nextLocated);
            located[nextLocated] = located[v] + 1;
          }
        }
      }
    }
  }
}
