class Solution {
    public String reorganizeString(String s) {
        if (s.length() <= 1)
            return s;
        Map<Character, Integer> m = new HashMap<>();
        for (char x : s.toCharArray()) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        ArrayList<Pair<Character, Integer>> freq = new ArrayList<>();
        Comparator<Pair<Character, Integer>> cmp = new Comparator<>() {
            @Override
            public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                return -Integer.compare(p1.getValue(), p2.getValue());
            }
        };

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            freq.add(new Pair<Character, Integer>(e.getKey(), e.getValue()));
        }
        Collections.sort(freq, cmp);
        // for(Pair<Character,Integer> x:freq){
        // System.out.println(x.getKey() + " "+ x.getValue());
        // }
        if (freq.get(0).getValue() > (s.length() + 1) / 2) {

            return "";
        }
        char[] ans = new char[s.length()];
        int ith = 0;
        for (int i = 0; i < ans.length; i += 2) {
            ans[i] = freq.get(ith).getKey();
            freq.set(ith, new Pair<Character, Integer>(freq.get(ith).getKey(), freq.get(ith).getValue() - 1));
            if (freq.get(ith).getValue() <= 0) {
                ith++;
            }
        }
        for (int i = 1; i < ans.length; i += 2) {
            ans[i] = freq.get(ith).getKey();
            freq.set(ith, new Pair<Character, Integer>(freq.get(ith).getKey(), freq.get(ith).getValue() - 1));
            if (freq.get(ith).getValue() <= 0) {
                ith++;
            }
        }
        // return s;
        return new String(ans);
    }
}