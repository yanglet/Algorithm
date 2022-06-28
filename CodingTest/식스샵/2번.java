import java.util.*;
// 머리가 돌에 맞은것처럼 안굴러가네 하

/**
    우선순위 큐를 사용
    반대로 들어가도록
    peek을 했을때 그대로면 페이지가 바뀐것
    peek보다 작은 애는 넣지 않음

    처음 넣을때 이름이 같으면 점수를 바꿔주고 answer++ 하면 안됨
*/
class Solution {
    public int solution(int K, String[] user_scores) {
        int answer = 1; // 첫 유저
        Queue<User> pq = new PriorityQueue<>();
        Set<String> names = new HashSet<>();
        String[] firstUser = user_scores[0].split("\\s+");
        pq.offer(new User(firstUser[0], Integer.valueOf(firstUser[1]), 1));
        names.add(firstUser[0]);

        for(int i=1; i<user_scores.length; i++){
            String[] info = user_scores[i].split("\\s+");
            User currentUser = new User(info[0], Integer.valueOf(info[1]), i + 1);

            // for(User user : pq){
            //     System.out.println(i + " name = " + user.getName() + " score = " + user.getScore() + " id = " + user.getId() );
            // }

            if(pq.size() != K){
                if( names.contains(currentUser.getName()) ){
                    for(User user : pq){
                        if(currentUser.getName().equals(user.getName())){
                            if(user.getScore() < currentUser.getScore()){
                                pq.remove(user);
                                pq.offer(currentUser);
                            }
                            break;
                        }
                    }
                }else{
                    answer++;
                    pq.offer(currentUser);
                    names.add(currentUser.getName());
                }
            }else{
                if(pq.peek().getScore() < currentUser.getScore()){
                    pq.offer(currentUser);

                    if( pq.peek().eq(currentUser) ){
                        answer++;
                        User oldUser = pq.poll();
                        names.add(currentUser.getName());
                        names.remove(oldUser.getName());
                    }
                }
            }
        }

        return answer;
    }


    public static class User implements Comparable<User>{
        private String name;
        private int score;
        private int id;

        public User(String name, int score, int id){
            this.name = name;
            this.score = score;
            this.id = id;
        }

        public String getName(){
            return this.name;
        }

        public int getScore(){
            return this.score;
        }

        public int getId(){
            return this.id;
        }

        public void setScore(int score){
            this.score = score;
        }

        @Override
        public int compareTo(User user){
            if(this.score > user.score){
                return 1;
            }else if(this.score < user.score){
                return -1;
            }else if(this.score == user.score){
                if(this.id > user.id){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return 0;
            }
        }

        public boolean eq(User user){
            if(this.name.equals(user.name)){ // 페이지에는 이름만 보임
                return true;
            }else{
                return false;
            }
        }
    }
}
