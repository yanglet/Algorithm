import java.util.*;

class Solution {
    public List<Integer> solution(int[][] datas) {
        List<Integer> answer = new ArrayList<>();
        Queue<Docs> pq = new PriorityQueue<>(); // 대기열
        int endTime = datas[0][1] + datas[0][2]; // 처음 인쇄가 끝나는 시각
        pq.offer(new Docs(datas[0][0], datas[0][1], datas[0][2])); // 첫 문서 대기열에 추가
        
        int index = 1;
        while( !pq.isEmpty() ){
            Docs docs = pq.poll();
            answer.add(docs.num);
            if(index > 1){
                endTime += docs.pages;
            }

            if(index < datas.length){
                for(int i=index; i<datas.length; i++){
                    if(datas[i][1] == endTime){ // 인쇄가 끝난 시각과 새로 요청된 문서의 요청 시각이 같으면 바로 처리
                        pq.offer(new Docs(datas[i][0], datas[i][1], datas[i][2]));
                        index++;
                        break;
                    }
                    if(datas[i][1] < endTime){ // 인쇄가 끝난 시각전에 요청된 문서들 전부 처리
                        pq.offer(new Docs(datas[i][0], datas[i][1], datas[i][2]));
                        index++;
                        continue;
                    }
                    break;
                }
                if(pq.isEmpty()){ // 대기 중인 문서가 없을 경우 요청 순서가 제일 빠른 문서 추가
                    pq.offer(new Docs(datas[index][0], datas[index][1], datas[index][2]));
                    index++;
                }
            }
        }
        return answer;
    }

    public static class Docs implements Comparable<Docs> {
        int num; // 문서 번호 ( 요청 순서 )
        int time; // 요청 시각
        int pages; // 페이지 수

        public Docs(int num, int time, int pages){
            this.num = num;
            this.time = time;
            this.pages = pages;
        }

        @Override
        public int compareTo(Docs docs){
            if(this.pages > docs.pages){
                return 1;
            }else if(this.pages < docs.pages){
                return -1;
            }else if(this.pages == docs.pages){
                if(this.time > docs.time){
                    return 1;
                }else if(this.time < docs.time){
                    return -1;
                }else{
                    return 0;
                }
            }
            return 0;
        }
    }
}
