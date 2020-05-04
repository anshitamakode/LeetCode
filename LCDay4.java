import java.util.Scanner;
class Solution {
    public int findComplement(int num) {
        int bitlen = (int) (Math.log(num) / Math.log(2) + 1);
        int bitmask = (1 << bitlen)-1;
        int comp = num ^ bitmask;
        return comp;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int no = sc.nextInt();
        int c = s.findComplement(no);
        System.out.println(c);
    }
}