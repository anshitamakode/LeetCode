class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> output = new ArrayList<>();
        int rs = 0;
        int cs = 0;
        int re = n-1;
        int ce = m-1;
        while(rs <= re && cs <= ce){
            for(int j=cs;j<=ce;j++){
                output.add(matrix[rs][j]);
            }
            rs++;
            for(int i=rs;i<=re;i++){
                output.add(matrix[i][ce]);
            }
            ce--;
            if(rs <= re){
                for(int j=ce;j>=cs;j--) {
                    output.add(matrix[re][j]);
                }
            }
            re--;
            if(cs <= ce) {
                for (int i=re;i>=rs;i--) {
                    output.add(matrix[i][cs]);
                }
            }
            cs++;
        }
        return output;
    }
}