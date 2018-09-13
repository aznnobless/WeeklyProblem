import java.util.ArrayList;
import java.util.List;

public class Week19 {

    // Week19 : Given a 2D integer array, print all elements
    //          in a circular spiral shape starting from[0][0]
    /*
     *  [
     *      [1, 2, 3],
     *      [8, 9, 4],
     *      [7, 6, 5]
     *  ]
     */

    // right, down, left, up
    private static int[] dy = {0,1,0,-1};
    private static int[] dx = {1,0,-1,-0};

    public boolean isSafe(int y, int x, int maxRow, int maxColumn)
    {
        return 0 <= y && y < maxRow && 0 <= x && x < maxColumn;
    }

    public List<Integer> getSolution(int[][] matrix)
    {
        List<Integer> toReturn = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return toReturn;

        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        int n = maxRow * maxColumn;

        boolean[][] visited = new boolean[maxRow][maxColumn];

        int y = 0;
        int x = 0;
        int nextY = 0;
        int nextX = 0;
        int currentDirectionIndex = 0;

        // complete search
        for(int i = 0;i < n; i++)
        {
            toReturn.add(matrix[y][x]);
            visited[y][x] = true;

            nextY = y + dy[currentDirectionIndex];
            nextX = x + dx[currentDirectionIndex];

            if (isSafe(nextY, nextX, maxRow, maxColumn) && !visited[nextY][nextX])
            {
                y = nextY;
                x = nextX;
            }
            else
            {
                currentDirectionIndex = (currentDirectionIndex+1) % dx.length;
                y += dy[currentDirectionIndex];
                x += dx[currentDirectionIndex];
            }
        }

        return toReturn;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        Week19 p = new Week19();
        List<Integer> result = p.getSolution(matrix);
        for(int n : result)
        {
            System.out.print(n + " ");
        }
    }
}
