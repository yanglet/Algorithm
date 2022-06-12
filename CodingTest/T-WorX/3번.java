import java.util.*;

class Solution {
    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        List<Plan> myPlans = new ArrayList<>();
        List<Client> myClients = new ArrayList<>();

        int idx = 0;
        for(String plan : plans){
            String[] data = plan.split("\\s+");

            int myData = Integer.parseInt(data[0]);
            List<Integer> service = new ArrayList<>();

            for(int i=1; i<data.length; i++){
                service.add(Integer.parseInt(data[i]));
            }

            myPlans.add(new Plan(myData, service));
        }

        for(String client : clients){
            String[] data = client.split("\\s+");
            
            int myData = Integer.parseInt(data[0]);
            List<Integer> service = new ArrayList<>();

            for(int i=1; i<data.length; i++){
                service.add(Integer.parseInt(data[i]));
            }

            myClients.add(new Client(myData, service));
        }

        for(int i=1; i<myPlans.size(); i++){
            for(int j=i-1; j<i; j++){
                for(int k=0; k<myPlans.get(j).service.size(); k++){
                    myPlans.get(i).service.add(myPlans.get(j).service.get(k));
                }
            }
        }

        int cIdx = 0;
        for(Client client : myClients){
            List<Integer> cService = client.service;
            int pIdx = 0;
            for(Plan plan : myPlans){
                List<Integer> pService = plan.service;
                Collections.sort(pService);

                if( client.data <= plan.data && pService.containsAll(cService) ){
                    answer[cIdx] = pIdx + 1;
                    break;
                }

                pIdx++;
            }
            cIdx++;
        }

        return answer;
    }

    public static class Plan{
        int data;
        List<Integer> service = new ArrayList<>();

        public Plan(int data, List<Integer> service){
            this.data = data;
            this.service = service;
        }
    }

    public static class Client{
        int data;
        List<Integer> service = new ArrayList<>();

        public Client(int data, List<Integer> service){
            this.data = data;
            this.service = service;
        }
    }
}
