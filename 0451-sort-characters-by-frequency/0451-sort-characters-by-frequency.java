class Pair{
    char c;
    int count;
    Pair(char c, int count){
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        list.sort((a,b) -> b.count - a.count);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            int cnt = list.get(i).count;
            while(cnt > 0){
                sb.append(list.get(i).c);
                cnt--;
            }
        }
        return sb.toString();
    }
}