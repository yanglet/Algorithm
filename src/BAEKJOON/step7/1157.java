import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] count = new int[26];
    String word = sc.nextLine();
    sc.close();
    
    for(int i=0; i<word.length(); i++){
      if('A'<= word.charAt(i) && 'Z' >= word.charAt(i)){
        count[word.charAt(i)-'A']++;
      }else{
        count[word.charAt(i)-'a']++;
      }
    }
    int max = -1;
    char ch = '?';
    for(int i=0; i<26; i++){
      if(max < count[i]){
        max = count[i];
        ch = (char)(i + 'A');
      }
      else if(max == count[i]){
        ch = '?';
      }
    }
    System.out.println(ch);
  }
}
