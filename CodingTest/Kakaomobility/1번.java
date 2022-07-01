// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Solution {
    public String solution(String S, String C) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        String[] nameList = S.split(", ");
        
        for(String name : nameList){
            String[] info = name.split("\\s+");
            String temp = "";

            if(info.length == 2){
                temp += String.valueOf(info[0].charAt(0));
                int len = info[1].length(); 

                info[1] = info[1].replace("-", "");
                
                temp += getTemp(len, info[1]);
            }else if(info.length == 3){
                temp += String.valueOf(info[0].charAt(0));
                temp += String.valueOf(info[1].charAt(0));
                int len = info[2].length(); 

                info[2] = info[2].replace("-", "");

                temp += getTemp(len, info[2]);
            }

            temp = temp.toLowerCase();

            if( map.getOrDefault(temp, 0) > 0){
                int num = map.getOrDefault(temp, 0) + 1;
                map.put(temp, num);
                temp += String.valueOf(num) + "@" + C.toLowerCase() + ".com";

                answer += getAnswer(answer, name, temp);
            }else if(map.getOrDefault(temp, 0) == 0){
                map.put(temp, 1);

                temp += "@" + C.toLowerCase() + ".com";

                answer += getAnswer(answer, name, temp);
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static String getTemp(int len, String info){
        if(len > 8){
            return info.substring(0, 8);
        }else{
            return info;
        }
    }

    public static String getAnswer(String answer, String name, String temp){
        if(answer.equals("")){
            return name + " " + "<" + temp + ">";
        }else{
            return ", " + name + " " + "<" + temp + ">";
        }
    }
}
