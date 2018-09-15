package basic;

public class HeapSort {

    private static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void heapfify(int[] arr)
    {
        if (arr == null || arr.length == 0) return;

        for (int i = 1; i < arr.length; i++)
        {
            int childIndex = i;

            do {

                int rootIndex = (childIndex -1) / 2;

                if (arr[childIndex] > arr[rootIndex]) swap(arr, childIndex, rootIndex);

                childIndex = rootIndex;

            } while (childIndex != 0);
        }
    }


    private void heapSort(int[] arr)
    {
        if (arr == null || arr.length == 0)

        heapfify(arr);

        for (int i = arr.length -1; i >= 0; i--)
        {
            swap(arr, 0, i);

            int rootIndex = 0;
            int childIndex = 1;

            do {
                childIndex = 2 * rootIndex + 1;

                if (childIndex < i - 1 && arr[childIndex] < arr[childIndex + 1])
                    childIndex++;

                if (childIndex < i && arr[rootIndex] < arr[childIndex])
                    swap(arr, rootIndex, childIndex);

                rootIndex = childIndex;

            } while(childIndex < i);
        }
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
        HeapSort p = new HeapSort();
        int[] arr = {7,6,5,8,3,5,9,1,6};
        p.heapSort(arr);
        print(arr);
    }

}
