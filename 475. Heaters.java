// https://leetcode.com/problems/heaters/description/

class Solution {
    // public int lower_bound(int arr[],int x){
    //     int i=0;
    //     int j=arr.length-1;
    //     int ans=-1;
    //     while(i<=j){
    //         int mid=i+(j-i)/2;
    //         if(arr[mid]>=x){
    //             ans=mid;
    //             j=mid-1;
    //         }else{
    //             i=mid+1;
    //         }
    //     }
    //     return ans;
    // }
    // public int upper_bound(int arr[],int x){
    //     int i=0;
    //     int j=arr.length-1;
    //     int ans=-1;
    //     while(i<=j){
    //         int mid=i+(j-i)/2;
    //         if(arr[mid]>x){
    //             ans=mid;
    //             j=mid-1;
                
    //         }else{
    //             i=mid+1;
    //         }
    //     }
    //     return ans;
    // }
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