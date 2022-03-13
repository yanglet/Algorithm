import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String sentence = sc.nextLine();

    StringTokenizer st = new StringTokenizer(sentence," ");

    System.out.println(st.countTokens());
  }
}
