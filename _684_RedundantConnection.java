// public class _684_RedundantConnection {

//     static int parents[];

//     static int find(int x) {
//         if (parents[x] == x) {
//             return x;
//         }
//         return parents[x] = find(parents[x]);
//     }

//     static void union(int x, int v) {
//         int px = find(x);
//         int pv = find(v);

//         parents[px] = pv;
//     }

//     public int[] findRedundantConnection(int[][] edges) {

//         int v = edges.length;

//         parents = new int[v + 1];

//         for (int i = 0; i < v; i++) {
//             parents[i] = i;
//         }

//         int[] ans = new int[2];
//         for (int[] is : edges) {
//             if (find(is[0]) == find(is[1])) {
//                 return ans = is;
//             }

//             union(is[0], is[1]);
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[][] edge = {{1,2},{2,3},{3,4},{1,4},{1,5}};

//         _684_RedundantConnection fConnection = new _684_RedundantConnection();

//         int[] ans = fConnection.findRedundantConnection(edge);

//         System.out.println(ans[0] + " : " + ans[1]);
//     }
// }


public class _684_RedundantConnection {

    static int parents[];

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]); // path compression
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parents[px] = py;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                return edge; // 
            }

            union(u, v);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] edge = {{1,2},{2,3},{3,4},{1,4},{1,5}};

        _684_RedundantConnection obj = new _684_RedundantConnection();
        int[] ans = obj.findRedundantConnection(edge);

        System.out.println(ans[0] + " : " + ans[1]);
    }
}