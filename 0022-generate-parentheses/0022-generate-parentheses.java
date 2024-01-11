class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String>();
    generateOneByOne("", list, n, n);
    return list;
}
    public void generateOneByOne(String sublist, List<String> list, int open, int close){
        if(open > close){
            return;
        }
        if(open > 0){
            generateOneByOne(sublist + "(" , list, open-1, close);
        }
        if(close > 0){
            generateOneByOne(sublist + ")" , list, open, close-1);
        }
        if(open == 0 && close == 0){
            list.add(sublist);
            return;
        }
    }
}