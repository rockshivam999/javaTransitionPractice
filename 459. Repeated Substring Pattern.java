// https://leetcode.com/problems/repeated-substring-pattern/description/

// Z-Algorithm

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        int[] z=new int[n];
        z[0]=0;
        // Boolean ok=false;
        int l=0,r=0;
        // if(n==1)return true;
        for(int i=1;i<n;i++){
            if(i<=r){
                z[i]=Math.min(r-l+1,z[i-l]);
            }
            while(i+z[i]<n && s.charAt(z[i])==s.charAt(z[i]+i)){
                z[i]++;
                if(i+z[i]==n && n%i==0  ){
                    return true;
                    // ok=true;
                }
            }
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
        }

        // for(char x:s.toCharArray())System.out.print(x+ " ");
        // System.out.println();
        // for(int x:z)System.out.print(x+ " ");
        // return ok;
        // if(ok)return ok;
        return false;
    }
}