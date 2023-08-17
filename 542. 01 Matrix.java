
// https://leetcode.com/problems/01-matrix/
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dis = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    if (dis[ni][nj] > dis[i][j] + 1) {
                        dis[ni][nj] = dis[i][j] + 1;
                        q.offer(new int[] { ni, nj });
                    }
                }
            }
        }

        return dis;
    }
}
