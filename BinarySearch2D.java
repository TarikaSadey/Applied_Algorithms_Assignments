public class BinarySearch2D {
    static int[] search(int[][] M, int q) {
        if (M.length == 0) {
            int[] A = {-1, -1};
            return A;
        }
        int R = M.length;
        int C = M[0].length;
        int x = 0;
        int n = (R * C) - 1;
        while (x <= n) {
            int mid = x + (n - x) / 2;
            int i = mid / C;
            int j = mid % C;
            if (M[i][j] == q) {
                int[] A1 = {i, j};
                return A1;
            }
            if (M[i][j] > q)
                n = mid - 1;
            else
                x = mid + 1;
        }
        int[] A2 = {-1, -1};
        return A2;
    }
}
