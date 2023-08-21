// https://leetcode.com/problems/4sum-ii/description/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> m1=new HashMap<>();
        Map<Integer,Integer> m2=new HashMap<>();

        for(int x:nums1){
            for(int y:nums2){
                m1.put(x+y,m1.getOrDefault(x+y,0)+1);
            }
        }

        for(int x:nums3){
            for(int y:nums4){
                m2.put(x+y,m2.getOrDefault(x+y,0)+1);
            }
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> x:m1.entrySet()){
            ans+= x.getValue()*m2.getOrDefault(-x.getKey(),0);
        }
        return ans;
    }
}