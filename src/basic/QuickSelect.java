package basic;

public class QuickSelect {

    public int quickSelect(int[] arr, int start, int end, int kth)
    {
        int i, j;
        kth = kth -1;

        do {
            i = start;
            j = end;

            while (i < j)
            {
                while (i <= end && arr[i] < arr[start]) i++;
                while (arr[j] > arr[start]) j--;
                if (i < j) swap(arr, i,j);
            }

            swap(arr, start, j);

            if (j < kth) start = j + 1;
            else end = j -1;

        } while(j != kth);

        return arr[kth];
    }

    public static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = {6,3,5,1,8,2,7,4};
        QuickSelect p = new QuickSelect();
        System.out.println(p.quickSelect(arr, 0, arr.length -1, 2));
    }

}
