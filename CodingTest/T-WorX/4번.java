import java.util.*;
// 집중이 안돼서 풀다가 제출했음ㅠㅠ 
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N;
    static int M;
    static int answer = 0;

    public int solution(String[] grid, int k) {
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M];

        bfs(grid, k);

        return answer;
    }

    public static void bfs(String[] grid, int k){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, k));
        visited[0][0] = true;

        while( !q.isEmpty() ){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                int dist = p.dist;

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if( grid[nextX].charAt(nextY) != '#' && visited[nextX][nextY] == false){
                        q.offer(new Point(nextX, nextY, dist - 1));
                        visited[nextX][nextY] = true;
                        if(dist == 0 && grid[p.x].charAt(p.y) == '.'){ // 평지이면서 더 이상 이동할 수 없으면 야영
                            answer++;
                            Point point = q.poll();
                            point.dist = k;
                            q.offer(point);
                        }
                        // dist 가 이어진 숲의 길이보다 작으면 야영
                        // 숲의 길이를 bfs로 ? ,,
                    }
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
