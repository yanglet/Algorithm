import java.util.*;
/**
  앞의 테스트 케이스는 전부 통과
  제출 테스트 케이스는 반 이상 불통
  이유가 뭘까 ,,
*/
class Solution {
    public String[] solution(String[] records, int k, String date) {
        String[] answer = {};
        Map<String, Integer> buyMap = new HashMap<>(); // (상품, 한 번 이상 구매한 고객 수)
        Map<String, Integer> buyAgainMap = new HashMap<>(); // (상품, 재구매한 고객 수)
        Map<String, Integer> buyTotalMap = new HashMap<>(); // (상품, 상품의 총 구매 수)
        Map<String, String> customerMap = new HashMap<>(); // (고객, 상품리스트)
        Set<String> pSet = new HashSet<>(); // 재구매 기간에 포함된 상품들
        List<Data> result = new ArrayList<>(); // 결과 계산을 위한 리스트

        for(String s : records){
            String[] info = s.split("\\s+");
            String startDate = getStartDate(date, k);

            // startDate 부터 date 까지 기간내에 있는 정보들
            if( info[0].compareTo(startDate) >= 0 && date.compareTo(info[0]) >= 0 ){
                buyTotalMap.put(info[2], buyTotalMap.getOrDefault(info[2], 0) + 1);
                customerMap.put(info[1], info[2] + " " + customerMap.getOrDefault(info[1], ""));
                pSet.add(info[2]);
            }
        }

        for(String p : pSet){
            for(Map.Entry<String, String> entry : customerMap.entrySet()){
                String[] pArray = entry.getValue().split("\\s+");
                
                // 한 번 이상 구매한 고객 수
                if( entry.getValue().contains(p) ){
                    buyMap.put(p, buyMap.getOrDefault(p, 0) + 1);
                }

                int check = 0;
                for(String s : pArray){
                    if(s.equals(p)){
                        check++;
                    }
                }

                // 재구매 고객 수
                if(check >= 2){
                    buyAgainMap.put(p, buyAgainMap.getOrDefault(p, 0) + 1);
                }else{
                    buyAgainMap.put(p, 0);
                }
            }
        }

        for(String p : pSet){
            Data data = new Data(p, buyMap.get(p), buyAgainMap.get(p), buyTotalMap.get(p));
            result.add(data);
        }

        Collections.sort(result);

        if(pSet.size() < 1){
            answer = new String[1];
            answer[0] = "no result";
            return answer;
        }else{
            answer = new String[pSet.size()];
        }
        
        int index = 0;
        for(Data data : result){
            answer[index++] = data.pName;
        }

        return answer;
    }

    public static class Data implements Comparable<Data>{
        String pName; // 상품 이름
        float rate; // 재구매율
        int buyTotalNum; // 총 구매
        
        public Data(String pName, int buyNum, int buyAgainNum, int buyTotalNum){
            this.pName = pName;
            this.rate = (float) buyAgainNum / buyNum * 100;
            this.buyTotalNum = buyTotalNum;
        }

        @Override
        public int compareTo(Data data){
            if(this.rate < data.rate){
                return 1;
            }else if(this.rate > data.rate){
                return -1;
            }else if(this.rate == data.rate){
                if(this.buyTotalNum < data.buyTotalNum){
                    return 1;
                }else if(this.buyTotalNum == data.buyTotalNum){
                    String temp1 = this.pName.substring(3);
                    String temp2 = data.pName.substring(3);

                    return Integer.valueOf(temp1) - Integer.valueOf(temp2);
                }else{
                    return -1;
                }
            }
            return 0;
        }
    }

    public static String getStartDate(String date, int k){
        String[] d = date.split("-");
        String year = "";
        String month = "";
        String day = "";

        int temp1 = (Integer.valueOf(d[1]) - 1) * 30; // 달을 일로 변경
        int temp2 = Integer.valueOf(d[2]); // 일
        int temp = temp1 + temp2;

        if(temp < k){
            int temp3 = k - temp;
            year = "2019";
            
            if(temp3 / 30 >= 1){
                int tMonth = temp3 / 30; // 달
                int tDay = temp3 % 30; // 일

                month = converter(12 - tMonth);
                day = converter(30 - tDay + 1);
            }else{
                int tDay = temp3 % 30;

                month = "12";
                day = converter(30 - tDay + 1);
            }
        }else{
            if( Integer.valueOf(d[2]) < k ){
                int tDay = k - Integer.valueOf(d[2]);
                int tMonth = Integer.valueOf(d[1]);

                day = converter(30 - tDay + 1);
                month = converter(tMonth - 1);
                year = d[0];
            }else{
                int tDay = Integer.valueOf(d[2]) - k + 1;

                day = converter(tDay);
                month = d[1];
                year = d[0];
            }
        }

        String startDate = year + "-" + month + "-" + day;
        return startDate;
    }

    public static String converter(int num){
        if(num < 10){
            return "0" + String.valueOf(num);
        }else{
            return String.valueOf(num);
        }
    }
}
