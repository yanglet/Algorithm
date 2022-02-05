class BubbleSort {
    public static void main(String args[]) {
        int sort[] = {3, 6, 2, 1, 5, 9, 10, 8, 4, 7};
        int temp;

        for(int i=0; i<sort.length; i++){
            for(int j=0; j<sort.length-i; j++){
                if(sort[j]>sort[j+1]){
                    temp = sort[j];
                    sort[j]=sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }
        for(int i=0; i<sort.length; i++){
            System.out.println(sort[i]);
        }
    }
}
