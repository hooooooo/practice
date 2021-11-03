class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i<nums.length - 2; i++){
            if(i == 0  || (nums[i] != nums[i-1])){
                int lo = i +1; 
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while(lo <hi && lo >= 0 && hi < nums.length){
                    if(sum == nums[lo] + nums[hi]){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);
                        result.add(tmp);                        
                        do
                        lo++; 
                        while(lo < nums.length && nums[lo] == nums[lo-1]);
                        
                        do
                        hi--;
                        while(hi >= 0 && nums[hi] == nums[hi+1]);
                    } else if(sum < nums[lo] + nums[hi]){
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        
        return result;
    }
}
