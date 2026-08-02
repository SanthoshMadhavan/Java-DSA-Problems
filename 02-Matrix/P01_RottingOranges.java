import java.util.LinkedList;
import java.util.Queue;

public class P01_RottingOranges {

    /*
     * Problem:
     *
     * Given a matrix where:
     * 0 = Empty cell
     * 1 = Fresh orange
     * 2 = Rotten orange
     *
     * Every minute, a rotten orange makes its adjacent
     * fresh oranges rotten.
     *
     * Return the minimum number of minutes required
     * to rot all fresh oranges.
     *
     * Return -1 if some fresh oranges can never become rotten.
     *
     * ------------------------------------------------
     * Example 1:
     *
     * Input:
     * [[2,1,1],
     *  [1,1,0],
     *  [0,1,1]]
     *
     * Output:
     * 4
     *
     * ------------------------------------------------
     * Example 2:
     *
     * Input:
     * [[2,1,1],
     *  [0,1,1],
     *  [1,0,1]]
     *
     * Output:
     * -1
     *
     * ------------------------------------------------
     * Approach:
     *
     * Use BFS because the oranges rot level by level,
     * where each BFS level represents one minute.
     *
     * 1. Add all initially rotten oranges to the queue.
     * 2. Process the queue level by level.
     * 3. Check the four adjacent cells.
     * 4. If an adjacent cell contains a fresh orange,
     *    make it rotten and add it to the queue.
     * 5. Increase elapsedTime after each level where
     *    at least one fresh orange becomes rotten.
     * 6. After BFS, check if any fresh orange remains.
     * 7. If yes, return -1; otherwise return elapsedTime.
     *
     * Pattern:
     * Matrix / Grid + BFS
     *
     * Time: O(n * m)
     * Space: O(n * m)
     */

    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    static int orangesRot(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        int elapsedTime = 0;

        // Add all initially rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // Four possible directions: down, right, up, left
        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        // BFS
        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottedAny = false;

            // Process one time level
            for (int i = 0; i < size; i++) {

                int[] cell = q.poll();

                int x = cell[0];
                int y = cell[1];

                // Check all four adjacent cells
                for (int[] dir : directions) {

                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (isSafe(nx, ny, n, m) && mat[nx][ny] == 1) {

                        // Make fresh orange rotten
                        mat[nx][ny] = 2;

                        q.add(new int[]{nx, ny});

                        rottedAny = true;
                    }
                }
            }

            // One minute has passed
            if (rottedAny) {
                elapsedTime++;
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }

        return elapsedTime;
    }
}