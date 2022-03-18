public class Main {
  static boolean[] check = new boolean[10000];
  
	public static void main(String[] args) {

    init();

    for(int i=0; i<10000; i++){
      if(check[i] == false){
        System.out.println(i+1);
      }
    }
  }

  public static void init(){
    for(int i=1; i<=10000; i++){
      int temp = i;
      int checkNum = 0;
      
      while(temp != 0){
        checkNum += temp % 10;
        temp /= 10;
      }
      checkNum += i;

      if(checkNum - 1 < 10000){
        check[checkNum - 1] = true;  
      }
    }
  }
}