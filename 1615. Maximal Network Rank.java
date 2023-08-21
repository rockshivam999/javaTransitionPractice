
// https://leetcode.com/problems/maximal-network-rank/description/
import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        int fans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ei = adj.get(i).size();
                int ej = adj.get(j).size();
                // System.out.println(i+" "+ei);
                // System.out.println(j+" "+ej);
                // System.out.println("====");
                int ans = ei + ej;
                if (adj.get(i).contains(j)) {
                    ans--;
                }
                fans = Math.max(fans, ans);
            }
        }
        return fans;

    }
}