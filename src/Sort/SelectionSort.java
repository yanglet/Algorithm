public class SelectionSort {
    public static void main(String args[]) {
        int sort[] = {3, 6, 2, 1, 5, 9, 10, 8, 4, 7};
        int min, temp, index;
        for (int i = 0; i < sort.length; i++) {
            min = sort[i];
            temp = sort[i];
            index = i;
            for (int j = i; j < sort.length; j++) {
                if (min > sort[j]) {
                    min = sort[j];
                    index = j;
                }
            }
            sort[i] = sort[index];
            sort[index] = temp;
        }
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i]+" ");

        }
    }
}
