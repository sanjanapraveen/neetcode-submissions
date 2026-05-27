class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>(); // Fix: use string representation for visited

        // Step 1: collect all treasures (value == 0)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        // Step 2: for each treasure, do BFS
        for (int[] tre : list) {
            q.add(tre);
            set.add(tre[0] + "," + tre[1]);
            int steps = 1;

            while (!q.isEmpty()) {
                int size = q.size(); // process level by level
                for (int i = 0; i < size; i++) {
                    int[] n = q.poll();
                    for (int[] dir : DIR) {
                        int r = n[0] + dir[0];
                        int c = n[1] + dir[1];
                        String key = r + "," + c;
                        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                                && !set.contains(key) && grid[r][c] > steps) {
                            grid[r][c] = steps;
                            q.add(new int[]{r, c});
                            set.add(key);
                        }
                    }
                }
                steps++;
            }

            set.clear(); // clear visited set for next treasure
        }
    }
}
