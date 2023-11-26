class Solution {
    public List<String> output = new ArrayList<>();
    public Map<Character, String> map = new HashMap<>();
    public void helper(String digits, StringBuilder sb, int index){
        if(index == digits.length()){
            output.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        String str = map.get(ch);
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            sb.append(c);
            helper(digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return output;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, new StringBuilder(), 0);
        return output;
    }
}