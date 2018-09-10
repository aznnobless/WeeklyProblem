
public class Week20
{
        /*
         * 정수 배열 arr이 있습니다. arr안의 각 원소의 값은 다음 원소의 인덱스입니다.
         * 이렇게 서로 이어지는 원소들의 배열이 있을때, arr[0]부터 시작하여 모든 원소를 들린
         * 다음 다시 arr[0]로 도착할 수 있는지 찾으시오.
         * 단, 시간복잡도는 O(n), 공간복잡도는 O(1).
         */

        public boolean solve(int[] nums)
        {
            int total = 0;
            for (int num : nums)
            {
                total += num;
            }

            int startIndex = 0;
            int nextIndex = 0;

            while (total > 0)
            {
                nextIndex = nums[startIndex];
                total -= nums[nextIndex];

                if (startIndex == nextIndex && total > 0) return false;
            }

            return total == 0;
        }

        public static void main(String[] args)
        {
            int[] sample1 = new int[]{1,2,4,0,3};
            int[] sample2 = new int[]{1,4,5,0,3,2};
            int[] sample3 = new int[]{1,2,2,0};
        }

}
