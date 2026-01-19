class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0, ele1=Integer.MIN_VALUE, cnt2=0, ele2=Integer.MIN_VALUE;
        int n = nums.length;
        int i=0;
        while(i<n){
            if(cnt1 == 0 && nums[i] != ele2) {
                ele1 = nums[i]; 
                cnt1=1;
            }
            else if(cnt2 == 0 && nums[i] != ele1) {
                ele2 = nums[i]; 
                cnt2=1;
            }
            else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
            i++;
        }
        cnt1=0;
        cnt2=0;
        for(i=0;i<n;i++){
            if(nums[i] == ele1)
                cnt1++;
            if(nums[i] == ele2)
                cnt2++;
        }
        System.out.println(ele1+" "+ele2);
        List<Integer> list = new ArrayList<>();
        if(cnt1 > n/3)
            list.add(ele1);
        if(cnt2 > n/3)
            list.add(ele2);
        return list;
    }
}