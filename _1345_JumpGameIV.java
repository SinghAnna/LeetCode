import java.util.*;

public class _1345_JumpGameIV {

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Step 1: build map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: BFS
        Queue<int[]> q = new java.util.LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int step = curr[1];

            if (i == n - 1) return step;

            // i+1
            if (i + 1 < n && !visited[i + 1]) {
                visited[i + 1] = true;
                q.add(new int[]{i + 1, step + 1});
            }

            // i-1
            if (i - 1 >= 0 && !visited[i - 1]) {
                visited[i - 1] = true;
                q.add(new int[]{i - 1, step + 1});
            }

            // same value indices
            if (map.containsKey(arr[i])) {
                for (int idx : map.get(arr[i])) {
                    if (!visited[idx]) {
                        visited[idx] = true;
                        q.add(new int[]{idx, step + 1});
                    }
                }
                map.remove(arr[i]); //  super important
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _1345_JumpGameIV minGameIV = new _1345_JumpGameIV();
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};

        int ans = minGameIV.minJumps(arr);
        System.out.println(ans);
    }
}