public class Week21 {

    // Week21 Problem: Implement an O(n log n) time  complexity sorting algorithm
    // input: [3,1,5,6]
    // output: [1,3,5,6]

    public void quickSort(int[] arr, int start, int end)
    {
        if (start>= end) return;

        int pivot = start;
        int i = start;
        int j = end;

        while (i < j)
        {
            while(i <= end && arr[i] < arr[pivot]) i++;
            while(j >= 0 && arr[j] > arr[pivot]) j--;

            if (i < j) swap(arr, pivot, j);
            else swap(arr, i, j);
        }
        quickSort(arr, start, j -1);
        quickSort(arr, j+1, end);
    }

    private void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void print(int[] arr)
    {
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] input = {3,1,5,6};
        Week21 p = new Week21();
        p.quickSort(input, 0, input.length-1);
        print(input);
    }

}
