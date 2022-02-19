class Solution {
    public int minimumDeviation(int[] nums) {
        // minimize vales
        int result = Integer.MAX_VALUE;
        
        int[] arr = new int[nums.length];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = nums[i];
            while(nums[i] % 2 == 0){
                nums[i] /= 2;
            }
        }
        
        long min = 0, max = 0;
        while(true) {
            min = nums[0];
            max = nums[0];
            for(int i = 1; i<nums.length; i++){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            
            result = Math.min((int)(max - min), result);
            
            boolean increased = true;
            
            for(int i = 0; i<nums.length; i++){
                if(min != nums[i]){
                    continue;   
                }
                if(min % 2 == 1){
                    nums[i] *= 2; 
                } else if(min < arr[i]) {
                    nums[i] *= 2;
                } else {
                    increased = false;
                    break;
                }
            }
            
            if(!increased){
                break;
            }
        }
        return result;
    }
}
