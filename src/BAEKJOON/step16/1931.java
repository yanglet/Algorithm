import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Conference> list = new ArrayList<Conference>();
    int count = 0;
    
    for(int i=0; i<n; i++){
      list.add(new Conference(sc.nextInt(), sc.nextInt()));
    }
    //종료 시간을 기준으로 내림차순 정렬(종료시간이 같다면 시작 시간을 기준으로 내림차순)
    Collections.sort(list, (a,b) -> a.getEnd()==b.getEnd() ? a.getStart()-b.getStart() : a.getEnd()-b.getEnd());

    int prev = 0;
    for(int i=0; i<n; i++){
      if(prev <= list.get(i).getStart()){
        prev = list.get(i).getEnd();
        count++;
      }
    }
    System.out.println(count);
  }
  public static class Conference {
    int start;
    int end;

    public Conference(int start, int end){
      this.start = start;
      this.end = end;
    }

    public int getStart(){
      return this.start;
    }
    public int getEnd(){
      return this.end;
    }
  }
}
