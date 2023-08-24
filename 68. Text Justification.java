// https://leetcode.com/problems/text-justification/description/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;
        List<String> fans = new ArrayList<String>();
        while(i<words.length){
            List<String> t=new ArrayList<String>();
            int s=0;
            while(i<words.length && s+words[i].length() -1 < maxWidth){
                t.add(words[i]);
                s+= words[i].length()+1;
                i++;
            }

            StringBuilder sb= new StringBuilder(String.join(" ",t));
            // sb=
            ArrayList<Integer> sp=new ArrayList<>();
            for(int k=0;k<sb.length();k++){
                if(sb.charAt(k)==' '){
                    sp.add(k);
                }
            }
            while(sb.length()<maxWidth){
                // System.out.println("stuck here");
                if(sp.size()>0){
                    for(int k=0;k<sp.size() && sb.length() < maxWidth; k++){
                        sb.insert(sp.get(k),new char[]{' '});
                        for(int kk=k+1;kk<sp.size();kk++){
                            sp.set(kk,sp.get(kk)+1);
                        }
                    }
                }else{
                    sb.append(' ');
                }
                
            }
            fans.add(sb.toString());
        }
        StringBuilder last=new StringBuilder();
        for(char x: fans.get(fans.size()-1).toCharArray() ){

            if(last.length()>0 &&  last.charAt(last.length() -1) == ' ' && x==' '   ){
                continue;
            }else{
                last.append(x);
            }
        }
        while(last.length()<maxWidth){
            last.append(' ');
        }
        // System.out.println(last.toString());
        fans.set(fans.size()-1,last.toString());

        return fans;
    }
}