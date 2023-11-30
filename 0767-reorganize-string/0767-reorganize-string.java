class Solution {
    class Pair {
    char ch;
    int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
            if (map.get(ch) > (n + 1)/2) {
                return "";
            }
        }   
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                p.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }   
        while(p.size() >= 2) {
            Pair p1 = p.remove();
            Pair p2 = p.remove();
            ans.append(p1.ch);
            ans.append(p2.ch);
            if (p1.freq > 1) {
                p.add(new Pair(p1.ch, p1.freq - 1));
            }
            if (p2.freq > 1) {
                p.add(new Pair(p2.ch, p2.freq - 1));
            }
        } 
        if (!p.isEmpty()) {
            ans.append(p.remove().ch);
        }
        return ans.toString();
    }
}