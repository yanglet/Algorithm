import java.util.*;
/**
    1. bfs 로 같은 값을 가진 영역을 찾는다. or 행을 찾는다 ?
    2. 같은 값을 가진 영역을 List에 담는다.
    3. 마름모가 될 수 있는지 판단한다. ( 영역내의 최대 크기의 마름모가 여러개라면??.. ㅠㅠ )
    못풀겠다 꾀꼬리
*/
class Solution {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static ArrayList<ArrayList<Point>> areas = new ArrayList<>();

    public int[] solution(int[][] grid) {
        int[] answer = new int[2];
        N = grid.length;
        M = grid[0].length;
        visited = new boolean[N][M];

        for(int i=0; i<N*M; i++){
            areas.add(new ArrayList<>());
        }

        int index = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] == false){
                    bfs(grid, new Point(i, j, grid[i][j]), index);
                    index++;
                }
            }
        }

        return answer;
    }

    public static void bfs(int[][] grid, Point point, int index){
        Queue<Point> q = new LinkedList<>();
        visited[point.x][point.y] = true;
        q.offer(new Point(0, 0, grid[point.x][point.y]));
        areas.get(index).add(point);

        while( !q.isEmpty() ){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(visited[nextX][nextY] == false && grid[nextX][nextY] == p.value){
                        q.offer(new Point(nextX, nextY, p.value));
                        visited[nextX][nextY] = true;
                        areas.get(index).add(point);
                    }
                }
            }
        }
    }
    public static class Point{
        int x;
        int y;
        int value;

        public Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
