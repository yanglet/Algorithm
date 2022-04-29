class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 5, y = 5;
        
        for(int i=0; i<dirs.length(); i++){
            switch( dirs.charAt(i) ){
                case 'U':
                    if(y >= 0 && y < 10 && x >= 0 && x <= 10){
                        y = y + 1;
                        if( !visited[x][y - 1][x][y] && !visited[x][y][x][y - 1] ){
                            visited[x][y - 1][x][y] = true;
                            visited[x][y][x][y - 1] = true;
                            answer++;
                        }
                    }
                    break;
                case 'D':
                    if(y > 0 && y <= 10 && x >= 0 && x <= 10){
                        y = y - 1;
                        if( !visited[x][y + 1][x][y] && !visited[x][y][x][y + 1] ){
                            visited[x][y + 1][x][y] = true;
                            visited[x][y][x][y + 1] = true;
                            answer++;
                        }
                    }
                    break;
                case 'R':
                    if(x >= 0 && x < 10 && y >= 0 && y <= 10){
                        x = x + 1;
                        if( !visited[x - 1][y][x][y] && !visited[x][y][x - 1][y] ){
                            visited[x - 1][y][x][y] = true;
                            visited[x][y][x - 1][y] = true;
                            answer++;
                        }
                    }
                    break;
                case 'L':
                    if(x > 0 && x <= 10 && y >= 0 && y <= 10){
                        x = x - 1;
                        if( !visited[x + 1][y][x][y] && !visited[x][y][x + 1][y] ){
                            visited[x + 1][y][x][y] = true;
                            visited[x][y][x + 1][y] = true;
                            answer++;
                        }
                    }
                    break;
            }
        }
        
        return answer;
    }
}
