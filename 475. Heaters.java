// https://leetcode.com/problems/heaters/description/

class Solution {
    
    public int findRadius(int[] houses, int[] heaters) {
        // Arrays.sort(houses);
        // Arrays.sort(heaters);
        int ans=0;
        for(int ho:houses){
            int dis=Integer.MAX_VALUE;
            for(int he:heaters){
                dis=Math.min(dis,Math.abs(ho-he));
            }
            ans=Math.max(ans,dis);
        }
        return ans;
    }
}

// efficient approach

class Solution {
    static int upper_bound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        for(int ho:houses){
            int dis=Integer.MAX_VALUE;
            int i=upper_bound(heaters,0,heaters.length,ho);
            if(i<heaters.length)
            dis=Math.min(dis,Math.abs(ho-heaters[i]));
            if(i>0){
                dis=Math.min(dis,Math.abs(ho-heaters[i-1]));
            }
            ans=Math.max(ans,dis);
        }
        return ans;
    }
}